package com.example.weather.feature_weather.domain.model.weather.value

import com.example.weather.feature_weather.domain.model.WeatherState


data class HourlyWeatherModel(
    val temperature: Double,
    val time: String,
    val weatherState: WeatherState,
    val isDay: Boolean,
)