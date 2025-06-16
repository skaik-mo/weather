package com.example.weather.feature_weather.domain.model


data class HourlyWeather(
    val temperature: String,
    val time: String,
    val weatherState: WeatherState,
    val isDay: Boolean,
)