package com.example.weather.feature_weather.domain.model

data class WeatherInfo(
    val currentWeather: CurrentWeather,
    val hourlyWeathers: List<HourlyWeather>,
    val dailyWeathers: List<DailyWeather>,
)