package com.example.weather.feature_weather.presentation.model

import com.example.weather.feature_weather.domain.model.WeatherState

data class CurrentWeather(
    val weatherState: WeatherState,
    val currentTemperature: String,
    val apparentTemperature: String,
    val windSpeed: String,
    val humidity: String,
    val rain: String,
    val uvIndex: String,
    val pressure: String,
    val isDay: Boolean,
) {
    constructor() : this(
        weatherState = WeatherState.Unknown,
        currentTemperature = "",
        apparentTemperature = "",
        windSpeed = "",
        humidity = "",
        rain = "",
        uvIndex = "",
        pressure = "",
        isDay = true
    )
}