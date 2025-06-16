package com.example.weather.feature_weather.data.datasource.api.api_files

sealed class ApiResult<out T> {
    data class Success<T>(val data: T, val statusCode: Int = 200) : ApiResult<T>()
    data class Error(val exception: Throwable, val message: String? = null, val statusCode: Int? = null) : ApiResult<Nothing>()
}