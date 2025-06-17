package com.example.weather.feature_weather.di

import com.example.weather.feature_weather.data.datasource.WeatherDatasource
import com.example.weather.feature_weather.data.datasource.api.WeatherDataSourceApi
import com.example.weather.feature_weather.data.datasource.api.api_files.RequestBuilder
import com.example.weather.feature_weather.data.repository.WeatherRepositoryImpl
import com.example.weather.feature_weather.domain.repository.WeatherRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    singleOf(::RequestBuilder)
    singleOf(::WeatherDataSourceApi) { bind<WeatherDatasource>() }
    singleOf(::WeatherRepositoryImpl) { bind<WeatherRepository>() }
}
