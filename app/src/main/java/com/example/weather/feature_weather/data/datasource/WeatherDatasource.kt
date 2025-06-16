package com.example.weather.feature_weather.data.datasource

import com.example.weather.feature_weather.data.model.WeatherInfoDTO

interface WeatherDatasource {
    suspend fun getWeather(latitude: Double, longitude: Double): WeatherInfoDTO
}