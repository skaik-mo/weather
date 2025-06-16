package com.example.weather.feature_weather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyWeatherUnitsDTO(
    @SerialName("time")
    val date: String,
    @SerialName("weather_code")
    val weatherCode: String,
    @SerialName("temperature_2m_max")
    val maxTemperature: String,
    @SerialName("temperature_2m_min")
    val minTemperature: String,
)