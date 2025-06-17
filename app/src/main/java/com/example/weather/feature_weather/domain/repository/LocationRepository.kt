package com.example.weather.feature_weather.domain.repository

import com.example.weather.feature_weather.domain.model.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location
}