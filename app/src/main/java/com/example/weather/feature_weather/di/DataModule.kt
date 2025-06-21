package com.example.weather.feature_weather.di

import com.example.weather.feature_weather.data.datasource.WeatherDatasource
import com.example.weather.feature_weather.data.datasource.api.WeatherDataSourceApi
import com.example.weather.feature_weather.data.network.BaseRequest
import com.example.weather.feature_weather.data.network.RequestBuilder
import com.example.weather.feature_weather.data.repository.GoogleLocationRepository
import com.example.weather.feature_weather.data.repository.WeatherRepositoryImpl
import com.example.weather.feature_weather.domain.repository.LocationRepository
import com.example.weather.feature_weather.domain.repository.WeatherRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

const val URL = "https://api.open-meteo.com/v1/"

val dataModule = module {
    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }
    }
    single {
        BaseRequest(URL)
    }
    singleOf(::RequestBuilder)
    singleOf(::WeatherDataSourceApi) { bind<WeatherDatasource>() }
    singleOf(::WeatherRepositoryImpl) { bind<WeatherRepository>() }
    singleOf(::GoogleLocationRepository) { bind<LocationRepository>() }
}
