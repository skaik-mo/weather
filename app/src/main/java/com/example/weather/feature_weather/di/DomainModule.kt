package com.example.weather.feature_weather.di

import com.example.weather.feature_weather.domain.exception.handler.SafeExecutor
import com.example.weather.feature_weather.domain.use_case.GetLocationUseCase
import com.example.weather.feature_weather.domain.use_case.GetWeatherDataUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::GetWeatherDataUseCase)
    singleOf(::SafeExecutor)
    singleOf(::GetLocationUseCase)
}
