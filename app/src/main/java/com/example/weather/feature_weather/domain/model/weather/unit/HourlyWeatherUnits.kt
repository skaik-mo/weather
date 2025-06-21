package com.example.weather.feature_weather.domain.model.weather.unit

data class HourlyWeatherUnits(
    val time: String,
    val weatherCode: String,
    val temperature: String,
    val isDay: String,
) {
    constructor() : this(
        time = "",
        weatherCode = "",
        temperature = "",
        isDay = "",
    )
}