package com.example.weather.feature_weather.presentation.screens.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.feature_weather.domain.model.weather.value.LocationModel
import com.example.weather.feature_weather.domain.use_case.GetLocationUseCase
import com.example.weather.feature_weather.domain.use_case.GetWeatherDataUseCase
import com.example.weather.feature_weather.presentation.exception.tryToExecute
import com.example.weather.feature_weather.presentation.mapper.toWeatherInfo
import com.example.weather.feature_weather.presentation.model.ErrorModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getLocationUseCase: GetLocationUseCase,
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
) : ViewModel() {
    private var _state = MutableStateFlow(WeatherUiState())
    val state: StateFlow<WeatherUiState> = _state.asStateFlow()

    init {
        getLocationAndWeatherData()
    }

    private fun getLocationAndWeatherData() {
        _state.value = _state.value.copy(
            isLoading = true
        )
        viewModelScope.launch {
            tryToExecute(
                action = {
                    getLocationUseCase.getLocation()
                },
                onSuccess = { location ->
                    getWeatherData(locationModel = location)
                },
                onError = ::handleError
            )
        }
    }

    private suspend fun getWeatherData(locationModel: LocationModel) {
        tryToExecute(
            action = {
                getWeatherDataUseCase.getWeatherData(
                    locationModel = locationModel
                )
            },
            onSuccess = { weatherInfo ->
                _state.value = _state.value.copy(
                    isLoading = false,
                    weatherInfo = weatherInfo.toWeatherInfo(),
                    locationModel = locationModel
                )
            },
            onError = ::handleError
        )
    }

    private fun handleError(throwable: Throwable) {
        _state.value = _state.value.copy(
            isLoading = false,
            errorModel = ErrorModel(isError = true, throwable),
        )
    }
}