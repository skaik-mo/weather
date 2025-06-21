package com.example.weather.feature_weather.presentation.mapper

import com.example.weather.feature_weather.domain.model.weather.unit.CurrentWeatherUnits
import com.example.weather.feature_weather.domain.model.weather.value.CurrentWeatherModel
import com.example.weather.feature_weather.presentation.model.CurrentWeather

fun CurrentWeatherModel.toCurrentWeather(units: CurrentWeatherUnits): CurrentWeather {
    return CurrentWeather(
        weatherState = this.weatherState,
        currentTemperature = "${this.currentTemperature} ${units.currentTemperature}",
        apparentTemperature = "${this.apparentTemperature} ${units.apparentTemperature}",
        windSpeed = "${this.windSpeed} ${units.windSpeed}",
        humidity = "${this.humidity} ${units.humidity}",
        rain = "${this.rain} ${units.rain}",
        uvIndex = "${this.uvIndex} ${units.uvIndex}",
        pressure = "${this.pressure} ${units.pressure}",
        isDay = this.isDay
    )
}