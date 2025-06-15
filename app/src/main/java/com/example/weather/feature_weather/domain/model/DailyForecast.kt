package com.example.weather.feature_weather.domain.model

import java.time.LocalDate

data class DailyForecast(
    val date: LocalDate,
    val weatherCode: Int,
    val maxTemperature: Float,
    val minTemperature: Float,
)