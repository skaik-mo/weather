package com.example.weather.app

import android.app.Application
import com.example.weather.feature_weather.di.dataModule
import com.example.weather.feature_weather.di.domainModule
import com.example.weather.feature_weather.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MyWeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyWeatherApplication)
            modules(
                dataModule,
                domainModule,
                presenterModule,
            )
        }
    }
}