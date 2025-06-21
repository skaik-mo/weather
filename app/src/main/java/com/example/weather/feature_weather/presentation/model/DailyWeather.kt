package com.example.weather.feature_weather.presentation.model

import com.example.weather.feature_weather.domain.model.WeatherState

data class DailyWeather(
    val date: String,
    val weatherState: WeatherState,
    val maxTemperature: String,
    val minTemperature: String,
)