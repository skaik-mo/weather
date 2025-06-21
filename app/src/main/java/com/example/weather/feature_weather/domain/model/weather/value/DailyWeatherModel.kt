package com.example.weather.feature_weather.domain.model.weather.value

import com.example.weather.feature_weather.domain.model.WeatherState
import java.time.LocalDate

data class DailyWeatherModel(
    val date: LocalDate,
    val weatherState: WeatherState,
    val maxTemperature: Double,
    val minTemperature: Double,
)