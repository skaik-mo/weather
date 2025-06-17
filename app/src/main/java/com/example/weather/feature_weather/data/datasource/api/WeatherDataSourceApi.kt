package com.example.weather.feature_weather.data.datasource.api

import com.example.weather.feature_weather.data.datasource.WeatherDatasource
import com.example.weather.feature_weather.data.datasource.api.api_files.ApiConstants
import com.example.weather.feature_weather.data.datasource.api.api_files.ApiResult
import com.example.weather.feature_weather.data.datasource.api.api_files.BaseRequest
import com.example.weather.feature_weather.data.datasource.api.api_files.RequestBuilder
import com.example.weather.feature_weather.data.model.WeatherInfoDTO

class WeatherDataSourceApi(
    val requestBuilder: RequestBuilder
) : WeatherDatasource {
    override suspend fun getWeather(
        latitude: Double,
        longitude: Double
    ): WeatherInfoDTO {
        val baseRequest = BaseRequest()
            .endpoint(ApiConstants.EndPoint.FORECAST)
            .addParameter(key = ApiConstants.Parameters.LATITUDE, value = latitude)
            .addParameter(key = ApiConstants.Parameters.LONGITUDE, value = longitude)
            .addParameter(key = ApiConstants.Parameters.TIMEZONE, value = "auto")
            .addParameter(
                key = ApiConstants.Parameters.CURRENT,
                value = "temperature_2m,relative_humidity_2m,apparent_temperature,is_day,wind_speed_10m,weather_code,pressure_msl,precipitation_probability,uv_index"
            )
            .addParameter(
                key = ApiConstants.Parameters.HOURLY,
                value = "temperature_2m,weather_code,is_day"
            )
            .addParameter(
                key = ApiConstants.Parameters.DAILY,
                value = "weather_code,temperature_2m_max,temperature_2m_min"
            )
        val result = requestBuilder.request<WeatherInfoDTO>(baseRequest = baseRequest)
        return when (result) {
            is ApiResult.Error -> throw result.exception
            is ApiResult.Success<WeatherInfoDTO> -> result.data
        }
    }
}