package com.example.weather.feature_weather.data.exceptions

import com.example.weather.feature_weather.data.exceptions.constants.ErrorMessageConstants

open class NetworkRequestException(message: String, val statusCode: Int? = null):Exception(message)

class NoInternetException : NetworkRequestException(ErrorMessageConstants.NO_INTERNET)

class InvalidRequestException : NetworkRequestException(ErrorMessageConstants.INVALID_REQUEST_CONFIG)

class InvalidRequestMethodException : NetworkRequestException(ErrorMessageConstants.UNSUPPORTED_HTTP_METHOD)

class ServerException(code: Int, message: String) : NetworkRequestException("${ErrorMessageConstants.CLIENT_ERROR_PREFIX} $message", code)

class ClientException(code: Int, message: String) : NetworkRequestException("${ErrorMessageConstants.SERVER_ERROR_PREFIX} $message", code)

class UnknownException(exception: Throwable) : NetworkRequestException("Unknown error: ${exception.message}")