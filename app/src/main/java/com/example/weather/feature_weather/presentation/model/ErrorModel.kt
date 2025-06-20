package com.example.weather.feature_weather.presentation.model

class ErrorModel(
    val isError: Boolean,
    val exception: Throwable
) {
    constructor(): this(
        isError = false,
        exception = Exception("Unknown")
    )
}