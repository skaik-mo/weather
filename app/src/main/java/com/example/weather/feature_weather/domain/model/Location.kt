package com.example.weather.feature_weather.domain.model

data class Location(
    val cityName: String,
    val latitude: Double,
    val longitude: Double
) {
    constructor(): this(
        cityName = "",
        latitude = 0.0,
        longitude = 0.0
    )
}