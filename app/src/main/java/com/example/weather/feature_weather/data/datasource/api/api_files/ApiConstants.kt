package com.example.weather.feature_weather.data.datasource.api.api_files

object ApiConstants {
    object BaseURL {
        const val URL = "https://api.open-meteo.com/v1/"
    }

    object EndPoint {
        const val FORECAST = "forecast"
    }

    object Parameters {
        const val LATITUDE = "latitude"
        const val LONGITUDE = "longitude"
        const val CURRENT = "current"
        const val HOURLY = "hourly"
        const val DAILY = "daily"
        const val TIMEZONE = "timezone"
    }
}