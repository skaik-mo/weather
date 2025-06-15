package com.example.weather.feature_weather.domain.model

data class WeatherInfo(
    val current: CurrentWeather,
    val hourly: List<HourlyWeather>,
    val dailyForecasts: List<DailyForecast>,
)