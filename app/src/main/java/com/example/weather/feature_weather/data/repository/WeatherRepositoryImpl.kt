package com.example.weather.feature_weather.data.repository

import com.example.weather.feature_weather.data.datasource.api.WeatherDataSourceApi
import com.example.weather.feature_weather.data.datasource.mapper.toWeatherInfo
import com.example.weather.feature_weather.domain.model.WeatherInfo
import com.example.weather.feature_weather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    val weatherDataSourceApi: WeatherDataSourceApi
) : WeatherRepository {
    override suspend fun getWeather(latitude: Double, longitude: Double): WeatherInfo {
        return weatherDataSourceApi.getWeather(latitude, longitude).toWeatherInfo()
    }
}