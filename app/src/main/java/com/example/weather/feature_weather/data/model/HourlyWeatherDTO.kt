package com.example.weather.feature_weather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeatherDTO(
    @SerialName("time")
    val time: List<String>,
    @SerialName("temperature_2m")
    val temperature: List<Double>,
    @SerialName("weather_code")
    val weatherCode: List<Int>,
    @SerialName("is_day")
    val isDay: List<Int>,
)