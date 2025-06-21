package com.example.weather.feature_weather.presentation.mapper

import com.example.weather.feature_weather.domain.model.weather.unit.HourlyWeatherUnits
import com.example.weather.feature_weather.domain.model.weather.value.HourlyWeatherModel
import com.example.weather.feature_weather.presentation.model.HourlyWeather

fun HourlyWeatherModel.toHourlyWeather(units: HourlyWeatherUnits): HourlyWeather {
    return HourlyWeather(
        temperature = "${this.temperature} ${units.temperature}",
        time = this.time,
        weatherState = this.weatherState,
        isDay = this.isDay
    )
}