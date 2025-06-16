package com.example.weather.feature_weather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherInfoDTO(
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double,
    @SerialName("generationtime_ms")
    val generationTime: Double,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int,
    @SerialName("timezone")
    val timezone: String,
    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    @SerialName("elevation")
    val elevation: Double,
    @SerialName("current_units")
    val currentWeatherUnits: CurrentWeatherUnitsDTO,
    @SerialName("current")
    val currentWeather: CurrentWeatherDTO,
    @SerialName("hourly_units")
    val hourlyWeatherUnits: HourlyWeatherUnitsDTO,
    @SerialName("hourly")
    val hourlyWeather: HourlyWeatherDTO,
    @SerialName("daily_units")
    val dailyWeatherUnits: DailyWeatherUnitsDTO,
    @SerialName("daily")
    val dailyWeather: DailyWeatherDTO,
)