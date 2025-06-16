package com.example.weather.feature_weather.data.datasource.mapper

import com.example.weather.feature_weather.data.model.DailyWeatherDTO
import com.example.weather.feature_weather.data.model.DailyWeatherUnitsDTO
import com.example.weather.feature_weather.domain.model.DailyWeather

fun DailyWeatherDTO.toDailyWeather(dailyUnits: DailyWeatherUnitsDTO): List<DailyWeather> {
    return date.mapIndexed { index, date ->
        DailyWeather(
            date = date,
            weatherState = weatherCodeMapper(this.weatherCode[index]),
            maxTemperature = "${this.maxTemperature[index]}${dailyUnits.maxTemperature}",
            minTemperature = "${this.minTemperature[index]}${dailyUnits.minTemperature}"
        )
    }
}