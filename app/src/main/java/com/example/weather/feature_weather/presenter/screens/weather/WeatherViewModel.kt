package com.example.weather.feature_weather.presenter.screens.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.feature_weather.domain.exception.handler.SafeExecutor
import com.example.weather.feature_weather.domain.model.Location
import com.example.weather.feature_weather.domain.use_case.GetWeatherDataUseCase
import com.example.weather.feature_weather.presenter.model.ErrorModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    val getWeatherDataUseCase: GetWeatherDataUseCase,
    val safeExecutor: SafeExecutor,
) : ViewModel() {
    private var _state = MutableStateFlow(WeatherUiState())
    val state: StateFlow<WeatherUiState> = _state.asStateFlow()

    init {
        getWeatherData()
    }

    private fun getWeatherData() {
        _state.value = _state.value.copy(
            isLoading = true
        )
        viewModelScope.launch {
            safeExecutor.tryToExecute(
                action = {
                    getWeatherDataUseCase.getWeatherData(
                        location = Location(
                            cityName = "",
                            latitude = 31.5016,
                            longitude = 34.4667
                        )
                    )
                },
                onSuccess = { weatherInfo ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        weatherInfo = weatherInfo,
                    )
                },
                onError = {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorModel = ErrorModel(isError = true, it),
                    )
                }
            )
        }
    }
}