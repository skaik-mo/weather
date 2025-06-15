package com.example.weather.feature_weather.domain.model

data class CurrentWeather(
    val weatherCode: Int,
    val currentTemperature: Float,
    val maxTemperature: Float,
    val minTemperature: Float,
    val apparentTemperature: Float,
    val windSpeedValue: Float,
    val relativeHumidity: Int,
    val totalRain: Int,
    val uvIndexValue: Int,
    val meanSeaLevelPressure: Float
)