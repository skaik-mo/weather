package com.example.weather.feature_weather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyWeatherDTO(
    @SerialName("time")
    val date: List<String>,
    @SerialName("weather_code")
    val weatherCode: List<Int>,
    @SerialName("temperature_2m_max")
    val maxTemperature: List<Double>,
    @SerialName("temperature_2m_min")
    val minTemperature: List<Double>,
)