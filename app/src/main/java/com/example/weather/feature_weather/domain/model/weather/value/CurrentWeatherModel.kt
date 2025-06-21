package com.example.weather.feature_weather.domain.model.weather.value

import com.example.weather.feature_weather.domain.model.WeatherState

data class CurrentWeatherModel(
    val weatherState: WeatherState,
    val currentTemperature: Double,
    val apparentTemperature: Double,
    val windSpeed: Double,
    val humidity: Int,
    val rain: Int,
    val uvIndex: Double,
    val pressure: Double,
    val isDay: Boolean,
) {
    constructor() : this(
        weatherState = WeatherState.Unknown,
        currentTemperature = 0.0,
        apparentTemperature = 0.0,
        windSpeed = 0.0,
        humidity = 0,
        rain = 0,
        uvIndex = 0.0,
        pressure = 0.0,
        isDay = true
    )
}