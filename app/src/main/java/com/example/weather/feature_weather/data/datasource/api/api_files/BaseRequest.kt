package com.example.weather.feature_weather.data.datasource.api.api_files

import io.ktor.http.HttpMethod

class BaseRequest {
    var baseURL: String = ApiConstants.BaseURL.URL
    var endPoint: String = ""
    var method: HttpMethod = HttpMethod.Get
    var headers: Map<String, String> = emptyMap()
    var parameters: Map<String, Any> = emptyMap()
    var body: Any? = null

    fun baseUrl(url: String) = apply { this.baseURL = url }

    fun endpoint(endpoint: String) = apply { this.endPoint = endpoint }

    fun method(method: HttpMethod) = apply { this.method = method }

    fun parameters(params: Map<String, Any>) = apply { this.parameters = params }

    fun addParameter(key: String, value: Any) = apply {
        this.parameters = this.parameters + (key to value)
    }

    fun headers(headers: Map<String, String>) = apply { this.headers = headers }

    fun addHeader(key: String, value: String) = apply {
        this.headers = this.headers + (key to value)
    }

    fun body(body: Any?) = apply { this.body = body }

    fun buildFullUrl(): String {
        val fullUrl = if (endPoint.isEmpty()) baseURL else "$baseURL$endPoint"

        return if (parameters.isNotEmpty() && method == HttpMethod.Get) {
            val queryString = parameters.entries.joinToString("&") { (key, value) ->
                "$key=$value"
            }
            "$fullUrl?$queryString"
        } else {
            fullUrl
        }
    }

    fun validate(): Boolean {
        return baseURL.isNotEmpty() &&
                baseURL.startsWith("http")
    }
}