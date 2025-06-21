package com.example.weather.feature_weather.domain.model.weather.unit

data class DailyWeatherUnits(
    val date: String,
    val weatherCode: String,
    val maxTemperature: String,
    val minTemperature: String,
) {
    constructor(): this(
        date = "",
        weatherCode = "",
        maxTemperature = "",
        minTemperature = "",
    )
}