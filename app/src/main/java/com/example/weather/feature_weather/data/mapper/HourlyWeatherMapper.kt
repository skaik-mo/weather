package com.example.weather.feature_weather.data.mapper

import com.example.weather.core.presenter.extensions.toHourFormat
import com.example.weather.feature_weather.data.model.HourlyWeatherDTO
import com.example.weather.feature_weather.data.model.HourlyWeatherUnitsDTO
import com.example.weather.feature_weather.domain.model.HourlyWeather
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun HourlyWeatherDTO.toHourlyWeather(
    unitsDTO: HourlyWeatherUnitsDTO,
    hours: List<Int>
): List<HourlyWeather> {
    return hours.map { index ->
        HourlyWeather(
            temperature = "${temperature[index]} ${unitsDTO.temperature}",
            time = time[index].toHourFormat(),
            weatherState = weatherCodeMapper(weatherCode[index]),
            isDay = isDay[index] == 1
        )
    }
}

fun HourlyWeatherDTO.filterRemainingTodayHours(): List<Int> {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val now = LocalDateTime.now()
    val today = now.toLocalDate()

    return time.indices.filter { i ->
        val dateTime = runCatching { LocalDateTime.parse(time[i], formatter) }.getOrNull()
        dateTime != null && dateTime.toLocalDate() == today && dateTime.isAfter(now)
    }
}