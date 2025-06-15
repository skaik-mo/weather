package com.example.weather.feature_weather.domain.model

import java.time.LocalDateTime

data class HourlyWeather(
    val temperature: Float,
    val time: LocalDateTime,
    val weatherCode: Int
)