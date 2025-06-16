package com.example.weather.feature_weather.domain.repository

import com.example.weather.feature_weather.domain.model.WeatherInfo

interface WeatherRepository {
    suspend fun getWeather(latitude: Double, longitude: Double): WeatherInfo
}