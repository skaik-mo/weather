package com.example.weather.feature_weather.domain.exception

import android.R.id.message

open class NetworkRequestException(message: String, val statusCode: Int? = null):Exception(message)

class NoInternetException : NetworkRequestException("No internet connection")

class TimeoutException : NetworkRequestException("Request timeout")

class InvalidRequestException : NetworkRequestException("Invalid request configuration")

class InvalidRequestMethodException : NetworkRequestException("Unsupported HTTP method")

class ServerException(code: Int, message: String) : NetworkRequestException("Server error: $message", code)

class ClientException(code: Int, message: String) : NetworkRequestException("Client error: $message", code)

class UnknownException(exception: Throwable) : NetworkRequestException("Unknown error: ${exception.message}")