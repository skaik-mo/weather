package com.example.weather.feature_weather.data.mapper

import com.example.weather.feature_weather.data.model.WeatherInfoDTO
import com.example.weather.feature_weather.domain.model.WeatherInfo

fun WeatherInfoDTO.toWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        currentWeather = this.currentWeather.toCurrentWeather(currentWeatherUnits),
        hourlyWeathers = hourlyWeather.toHourlyWeather(
            hourlyWeatherUnits,
            hourlyWeather.filterRemainingTodayHours()
        ),
        dailyWeathers = dailyWeather.toDailyWeather(dailyWeatherUnits),
    )
}