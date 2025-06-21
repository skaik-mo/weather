package com.example.weather.feature_weather.data.mapper

import com.example.weather.core.extensions.toHourFormat
import com.example.weather.feature_weather.data.model.HourlyWeatherDTO
import com.example.weather.feature_weather.data.model.HourlyWeatherUnitsDTO
import com.example.weather.feature_weather.domain.model.weather.unit.HourlyWeatherUnits
import com.example.weather.feature_weather.domain.model.weather.value.HourlyWeatherModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun HourlyWeatherDTO.toHourlyWeather(hours: List<Int>): List<HourlyWeatherModel> {
    return hours.map { index ->
        HourlyWeatherModel(
            temperature = temperature[index],
            time = time[index].toHourFormat(),
            weatherState = weatherCodeMapper(weatherCode[index]),
            isDay = isDay[index] == 1
        )
    }
}


fun HourlyWeatherUnitsDTO.toHourlyWeatherUnits(): HourlyWeatherUnits {
    return HourlyWeatherUnits(
        temperature = this.temperature,
        time = this.time,
        weatherCode = this.weatherCode,
        isDay = this.isDay
    )
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