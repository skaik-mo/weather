package com.example.weather.feature_weather.presentation.mapper

import com.example.weather.feature_weather.domain.model.weather.value.WeatherInfoModel
import com.example.weather.feature_weather.presentation.model.CurrentWeather
import com.example.weather.feature_weather.presentation.model.DailyWeather
import com.example.weather.feature_weather.presentation.model.HourlyWeather
import com.example.weather.feature_weather.presentation.model.WeatherInfo

fun WeatherInfoModel.toWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        currentWeather = toCurrentWeather(),
        hourlyWeathers = this.toHourlyWeather(),
        dailyWeathers = this.toDailyWeather(),
    )
}

private fun WeatherInfoModel.toCurrentWeather(): CurrentWeather =
    this.currentWeatherModel.toCurrentWeather(this.currentWeatherUnits)

fun WeatherInfoModel.toDailyWeather(): List<DailyWeather> {
    return this.dailyWeatherModels.map {
        it.toDailyWeather(this.dailyWeatherUnits)
    }
}

fun WeatherInfoModel.toHourlyWeather(): List<HourlyWeather> {
    return this.hourlyWeatherModels.map {
        it.toHourlyWeather(this.hourlyWeatherUnits)
    }
}