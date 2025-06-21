package com.example.weather.feature_weather.presentation.mapper

import com.example.weather.feature_weather.domain.model.weather.unit.DailyWeatherUnits
import com.example.weather.feature_weather.domain.model.weather.value.DailyWeatherModel
import com.example.weather.feature_weather.presentation.model.DailyWeather

fun DailyWeatherModel.toDailyWeather(units: DailyWeatherUnits): DailyWeather {
    return DailyWeather(
        date = this.date.toString(),
        weatherState = this.weatherState,
        maxTemperature = "${this.maxTemperature} ${units.maxTemperature}",
        minTemperature = "${this.minTemperature} ${units.minTemperature}",
    )
}