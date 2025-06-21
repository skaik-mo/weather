package com.example.weather.feature_weather.domain.use_case

import com.example.weather.feature_weather.domain.repository.LocationRepository
import com.example.weather.feature_weather.domain.model.weather.value.LocationModel

class GetLocationUseCase(
    private val locationRepository: LocationRepository
) {
    suspend fun getLocation(): LocationModel{
        return locationRepository.getCurrentLocation()
    }
}