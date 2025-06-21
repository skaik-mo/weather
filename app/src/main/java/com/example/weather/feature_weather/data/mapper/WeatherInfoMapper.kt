package com.example.weather.feature_weather.data.mapper

import com.example.weather.feature_weather.data.model.WeatherInfoDTO
import com.example.weather.feature_weather.domain.model.weather.value.WeatherInfoModel

fun WeatherInfoDTO.toWeatherInfo(): WeatherInfoModel {
    return WeatherInfoModel(
        currentWeatherModel = this.currentWeather.toCurrentWeather(),
        currentWeatherUnits = this.currentWeatherUnits.toCurrentWeatherUnits(),
        hourlyWeatherModels = this.hourlyWeather.toHourlyWeather(this.hourlyWeather.filterRemainingTodayHours()),
        hourlyWeatherUnits = this.hourlyWeatherUnits.toHourlyWeatherUnits(),
        dailyWeatherModels = this.dailyWeather.toDailyWeather(),
        dailyWeatherUnits = this.dailyWeatherUnits.toDailyWeatherUnit(),
    )
}