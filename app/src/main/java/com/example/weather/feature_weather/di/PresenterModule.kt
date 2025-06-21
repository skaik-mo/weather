package com.example.weather.feature_weather.di

import com.example.weather.feature_weather.presentation.screens.weather.WeatherViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val presenterModule = module {
    singleOf(::WeatherViewModel)
}