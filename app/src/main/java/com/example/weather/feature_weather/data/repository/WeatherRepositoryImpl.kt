package com.example.weather.feature_weather.data.repository

import com.example.weather.feature_weather.data.datasource.WeatherDatasource
import com.example.weather.feature_weather.data.mapper.toWeatherInfo
import com.example.weather.feature_weather.domain.model.WeatherInfo
import com.example.weather.feature_weather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    val weatherDataSource: WeatherDatasource
) : WeatherRepository {
    override suspend fun getWeather(latitude: Double, longitude: Double): WeatherInfo {
        return weatherDataSource.getWeather(latitude, longitude).toWeatherInfo()
    }
}