package com.example.weather.feature_weather.data.mapper

import com.example.weather.feature_weather.data.model.CurrentWeatherDTO
import com.example.weather.feature_weather.data.model.CurrentWeatherUnitsDTO
import com.example.weather.feature_weather.domain.model.weather.unit.CurrentWeatherUnits
import com.example.weather.feature_weather.domain.model.weather.value.CurrentWeatherModel

fun CurrentWeatherDTO.toCurrentWeather(): CurrentWeatherModel {
    return CurrentWeatherModel(
        weatherState = weatherCodeMapper(weatherCode),
        currentTemperature = this.temperature,
        apparentTemperature = this.apparentTemperature,
        windSpeed = this.windSpeed,
        humidity = this.relativeHumidity,
        rain = this.rain.toInt(),
        uvIndex = this.uvIndex,
        pressure = this.pressure,
        isDay = this.isDay == 1
    )
}

fun CurrentWeatherUnitsDTO.toCurrentWeatherUnits(): CurrentWeatherUnits {
    return CurrentWeatherUnits(
        apparentTemperature = this.apparentTemperature,
        rain = this.rain,
        pressure = this.pressure,
        humidity = this.relativeHumidity,
        isDay = this.isDay,
        currentTemperature = this.temperature,
        uvIndex = this.uvIndex,
        windSpeed = this.windSpeed,
        time = this.time,
    )
}
