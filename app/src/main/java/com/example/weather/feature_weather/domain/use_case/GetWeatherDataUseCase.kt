package com.example.weather.feature_weather.domain.use_case

import com.example.weather.feature_weather.domain.model.Location
import com.example.weather.feature_weather.domain.model.WeatherInfo
import com.example.weather.feature_weather.domain.repository.WeatherRepository

class GetWeatherDataUseCase(
    private val repository: WeatherRepository
) {
    suspend fun getWeatherData(location: Location): WeatherInfo {
        return repository.getWeather(latitude = location.latitude, longitude = location.longitude)
    }
}