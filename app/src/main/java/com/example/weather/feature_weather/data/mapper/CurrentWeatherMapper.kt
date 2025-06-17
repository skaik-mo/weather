package com.example.weather.feature_weather.data.mapper

import com.example.weather.feature_weather.data.model.CurrentWeatherDTO
import com.example.weather.feature_weather.data.model.CurrentWeatherUnitsDTO
import com.example.weather.feature_weather.domain.model.CurrentWeather

fun CurrentWeatherDTO.toCurrentWeather(unitsDTO: CurrentWeatherUnitsDTO): CurrentWeather {
    return CurrentWeather(
        weatherState = weatherCodeMapper(weatherCode),
        currentTemperature = "${this.temperature}${unitsDTO.temperature}",
        apparentTemperature = "${this.apparentTemperature}${unitsDTO.apparentTemperature}",
        windSpeed = "${this.windSpeed} ${unitsDTO.windSpeed}",
        humidity = "${this.relativeHumidity}${unitsDTO.relativeHumidity}",
        rain = "${this.rain}${unitsDTO.rain}",
        uvIndex = "${this.uvIndex}${unitsDTO.uvIndex}",
        pressure = "${this.pressure} ${unitsDTO.pressure}",
        isDay = this.isDay == 1
    )
}