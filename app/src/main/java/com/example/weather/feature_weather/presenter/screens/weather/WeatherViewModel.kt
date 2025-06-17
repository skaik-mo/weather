package com.example.weather.feature_weather.presenter.screens.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.feature_weather.domain.exception.handler.SafeExecutor
import com.example.weather.feature_weather.domain.model.Location
import com.example.weather.feature_weather.domain.use_case.GetLocationUseCase
import com.example.weather.feature_weather.domain.use_case.GetWeatherDataUseCase
import com.example.weather.feature_weather.presenter.model.ErrorModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getLocationUseCase: GetLocationUseCase,
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
    private val safeExecutor: SafeExecutor,
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
            safeExecutor.tryToExecute(
                action = {
                    getLocationUseCase.getLocation()
                },
                onSuccess = { location ->
                    getWeatherData(location = location)
                },
                onError = ::handleError
            )
        }
    }

    private suspend fun getWeatherData(location: Location) {
        safeExecutor.tryToExecute(
            action = {
                getWeatherDataUseCase.getWeatherData(
                    location = location
                )
            },
            onSuccess = { weatherInfo ->
                _state.value = _state.value.copy(
                    isLoading = false,
                    weatherInfo = weatherInfo,
                    location = location
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