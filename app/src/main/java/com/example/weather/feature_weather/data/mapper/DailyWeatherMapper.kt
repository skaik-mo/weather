package com.example.weather.feature_weather.data.mapper

import com.example.weather.core.extensions.toLocalDate
import com.example.weather.feature_weather.data.model.DailyWeatherDTO
import com.example.weather.feature_weather.data.model.DailyWeatherUnitsDTO
import com.example.weather.feature_weather.domain.model.weather.unit.DailyWeatherUnits
import com.example.weather.feature_weather.domain.model.weather.value.DailyWeatherModel

fun DailyWeatherDTO.toDailyWeather(): List<DailyWeatherModel> {
    return date.mapIndexed { index, date ->
        DailyWeatherModel(
            date = date.toLocalDate(),
            weatherState = weatherCodeMapper(this.weatherCode[index]),
            maxTemperature = this.maxTemperature[index],
            minTemperature = this.minTemperature[index],
        )
    }
}

fun DailyWeatherUnitsDTO.toDailyWeatherUnit(): DailyWeatherUnits {
    return DailyWeatherUnits(
        date = this.date,
        weatherCode = this.weatherCode,
        maxTemperature = this.maxTemperature,
        minTemperature = this.minTemperature,
    )
}