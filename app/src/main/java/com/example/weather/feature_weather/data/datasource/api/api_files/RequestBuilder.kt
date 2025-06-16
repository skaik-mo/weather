package com.example.weather.feature_weather.data.datasource.api.api_files

import com.example.weather.feature_weather.domain.exception.ClientException
import com.example.weather.feature_weather.domain.exception.InvalidRequestException
import com.example.weather.feature_weather.domain.exception.InvalidRequestMethodException
import com.example.weather.feature_weather.domain.exception.ServerException
import com.example.weather.feature_weather.domain.exception.UnknownException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RequestBuilder {
    private val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend inline fun <reified T> request(baseRequest: BaseRequest): ApiResult<T> {
        return withContext(Dispatchers.IO) {
            if (!baseRequest.validate()) {
                return@withContext ApiResult.Error(
                    exception = InvalidRequestException(),
                    message = "Request validation failed"
                )
            }
            val response = executeRequest(baseRequest)
            handleResponse<T>(response)
        }
    }

    suspend fun executeRequest(baseRequest: BaseRequest): HttpResponse {
        val url = baseRequest.buildFullUrl()
        return when (baseRequest.method) {
            HttpMethod.Get -> httpClient.get(url) {
                configureRequest(baseRequest)
            }

            HttpMethod.Post -> httpClient.post(url) {
                configureRequestWithBody(baseRequest)
            }

            HttpMethod.Put -> httpClient.put(url) {
                configureRequestWithBody(baseRequest)
            }

            HttpMethod.Delete -> httpClient.delete(url) {
                configureRequest(baseRequest)
            }

            else -> throw InvalidRequestMethodException()
        }
    }

    private fun HttpRequestBuilder.configureRequestWithBody(baseRequest: BaseRequest) {
        configureRequest(baseRequest)
        setRequestBody(baseRequest)
    }

    private fun HttpRequestBuilder.configureRequest(baseRequest: BaseRequest) {
        headers {
            baseRequest.headers.forEach { (key, value) ->
                append(key, value)
            }
        }
    }

    private fun HttpRequestBuilder.setRequestBody(baseRequest: BaseRequest) {
        when (val body = baseRequest.body) {
            is String -> {
                contentType(ContentType.Application.Json)
                setBody(body)
            }

            null -> {
                if (baseRequest.parameters.isNotEmpty()) {
                    val formParameters =
                        baseRequest.parameters.entries.joinToString("&") { (key, value) -> "$key=$value" }
                    contentType(ContentType.Application.FormUrlEncoded)
                    setBody(formParameters)
                }
            }

            else -> {
                contentType(ContentType.Application.Json)
                setBody(body)
            }
        }
    }

    suspend inline fun <reified T> handleResponse(response: HttpResponse): ApiResult<T> {
        return when (response.status.value) {
            in 200..299 -> {
                ApiResult.Success(response.body<T>(), response.status.value)
            }

            in 400..499 -> {
                val errorBody = response.bodyAsText()
                ApiResult.Error(
                    exception = ClientException(
                        response.status.value,
                        errorBody
                    ),
                    message = "Client error: ${response.status.description}",
                    statusCode = response.status.value
                )
            }

            in 500..599 -> {
                val errorBody = response.bodyAsText()
                ApiResult.Error(
                    exception = ServerException(
                        response.status.value,
                        errorBody
                    ),
                    message = "Server error: ${response.status.description}",
                    statusCode = response.status.value
                )
            }

            else -> {
                ApiResult.Error(
                    exception = UnknownException(Exception("Unexpected status: ${response.status.value}")),
                    message = "Unexpected response status: ${response.status.value}",
                    statusCode = response.status.value
                )
            }
        }
    }

}