package com.example.weather.feature_weather.domain.model


data class DailyWeather(
    val date: String,
    val weatherState: WeatherState,
    val maxTemperature: String,
    val minTemperature: String,
)