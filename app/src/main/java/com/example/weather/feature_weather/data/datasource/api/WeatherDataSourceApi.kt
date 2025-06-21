package com.example.weather.feature_weather.data.datasource.api

import com.example.weather.feature_weather.data.datasource.WeatherDatasource
import com.example.weather.feature_weather.data.network.ApiResult
import com.example.weather.feature_weather.data.network.BaseRequest
import com.example.weather.feature_weather.data.network.RequestBuilder
import com.example.weather.feature_weather.data.model.WeatherInfoDTO

class WeatherDataSourceApi(
    val requestBuilder: RequestBuilder,
    val baseRequest: BaseRequest
) : WeatherDatasource {

    override suspend fun getWeather(
        latitude: Double,
        longitude: Double
    ): WeatherInfoDTO {
        val latitudeKey = "latitude"
        val longitudeKey = "longitude"
        val currentKey = "current"
        val hourlyKey = "hourly"
        val dailyKey = "daily"
        val timezoneKey = "timezone"
        val endpoint = "forecast"
        baseRequest
            .endpoint(endpoint)
            .addParameter(key = latitudeKey, value = latitude)
            .addParameter(key = longitudeKey, value = longitude)
            .addParameter(key = timezoneKey, value = "auto")
            .addParameter(
                key = currentKey,
                value = "temperature_2m,relative_humidity_2m,apparent_temperature,is_day,wind_speed_10m,weather_code,pressure_msl,precipitation_probability,uv_index"
            )
            .addParameter(
                key = hourlyKey,
                value = "temperature_2m,weather_code,is_day"
            )
            .addParameter(
                key = dailyKey,
                value = "weather_code,temperature_2m_max,temperature_2m_min"
            )
        val result = requestBuilder.request<WeatherInfoDTO>(baseRequest = baseRequest)
        return when (result) {
            is ApiResult.Error -> throw result.exception
            is ApiResult.Success<WeatherInfoDTO> -> result.data
        }
    }
}