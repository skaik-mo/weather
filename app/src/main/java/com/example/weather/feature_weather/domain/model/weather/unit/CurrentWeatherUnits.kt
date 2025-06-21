package com.example.weather.feature_weather.domain.model.weather.unit

data class CurrentWeatherUnits(
    val apparentTemperature: String,
    val rain: String,
    val pressure: String,
    val humidity: String,
    val isDay: String,
    val currentTemperature: String,
    val uvIndex: String,
    val time: String,
    val windSpeed: String,
) {
    constructor() : this(
        apparentTemperature = "",
        rain = "",
        pressure = "",
        humidity = "",
        isDay = "",
        currentTemperature = "",
        uvIndex = "",
        windSpeed = "",
        time = "",
    )
}