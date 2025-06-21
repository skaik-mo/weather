package com.example.weather.feature_weather.domain.model.weather.value

data class LocationModel(
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