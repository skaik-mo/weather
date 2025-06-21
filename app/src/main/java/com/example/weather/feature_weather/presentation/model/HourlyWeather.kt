package com.example.weather.feature_weather.presentation.model

import com.example.weather.feature_weather.domain.model.WeatherState

data class HourlyWeather(
    val temperature: String,
    val time: String,
    val weatherState: WeatherState,
    val isDay: Boolean,
)