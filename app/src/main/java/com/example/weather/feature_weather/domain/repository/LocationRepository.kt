package com.example.weather.feature_weather.domain.repository

import com.example.weather.feature_weather.domain.model.weather.value.LocationModel

interface LocationRepository {
    suspend fun getCurrentLocation(): LocationModel
}