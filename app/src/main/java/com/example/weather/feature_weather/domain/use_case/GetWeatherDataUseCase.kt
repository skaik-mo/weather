package com.example.weather.feature_weather.domain.use_case

import com.example.weather.feature_weather.domain.model.weather.value.LocationModel
import com.example.weather.feature_weather.domain.model.weather.value.WeatherInfoModel
import com.example.weather.feature_weather.domain.repository.WeatherRepository

class GetWeatherDataUseCase(
    private val repository: WeatherRepository
) {
    suspend fun getWeatherData(locationModel: LocationModel): WeatherInfoModel {
        return repository.getWeather(latitude = locationModel.latitude, longitude = locationModel.longitude)
    }
}