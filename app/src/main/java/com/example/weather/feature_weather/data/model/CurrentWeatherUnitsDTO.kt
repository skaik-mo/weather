package com.example.weather.feature_weather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherUnitsDTO(
    @SerialName("apparent_temperature")
    val apparentTemperature: String,
    @SerialName("interval")
    val interval: String,
    @SerialName("precipitation_probability")
    val rain: String,
    @SerialName("pressure_msl")
    val pressure: String,
    @SerialName("relative_humidity_2m")
    val relativeHumidity: String,
    @SerialName("is_day")
    val isDay: String,
    @SerialName("temperature_2m")
    val temperature: String,
    @SerialName("uv_index")
    val uvIndex: String,
    @SerialName("time")
    val time: String,
    @SerialName("weather_code")
    val weatherCode: String,
    @SerialName("wind_speed_10m")
    val windSpeed: String,
)