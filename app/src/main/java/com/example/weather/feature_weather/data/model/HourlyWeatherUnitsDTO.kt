package com.example.weather.feature_weather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeatherUnitsDTO(
    @SerialName("time")
    val time: String,
    @SerialName("weather_code")
    val weatherCode: String,
    @SerialName("temperature_2m")
    val temperature: String,
    @SerialName("is_day")
    val isDay: String,
)