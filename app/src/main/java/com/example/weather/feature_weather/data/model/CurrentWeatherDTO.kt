package com.example.weather.feature_weather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDTO(
    @SerialName("time")
    val time: String,
    @SerialName("interval")
    val interval: Int,
    @SerialName("temperature_2m")
    val temperature: Double,
    @SerialName("relative_humidity_2m")
    val relativeHumidity: Int,
    @SerialName("apparent_temperature")
    val apparentTemperature: Double,
    @SerialName("is_day")
    val isDay: Int,
    @SerialName("wind_speed_10m")
    val windSpeed: Double,
    @SerialName("weather_code")
    val weatherCode: Int,
    @SerialName("pressure_msl")
    val pressure: Double,
    @SerialName("precipitation_probability")
    val rain: Double,
    @SerialName("uv_index")
    val uvIndex: Double,
)