package com.example.weather.feature_weather.data.datasource.mapper

import com.example.weather.feature_weather.domain.model.WeatherState

val weatherCodeMap = mapOf(
    0 to WeatherState.ClearSky,
    1 to WeatherState.MainlyClear,
    2 to WeatherState.PartlyCloudy,
    3 to WeatherState.Overcast,
    45 to WeatherState.Fog,
    48 to WeatherState.DepositingRimeFog,
    51 to WeatherState.DrizzleLight,
    53 to WeatherState.DrizzleModerate,
    55 to WeatherState.DrizzleDense,
    56 to WeatherState.FreezingDrizzleLight,
    57 to WeatherState.FreezingDrizzleDense,
    61 to WeatherState.RainSlight,
    63 to WeatherState.RainModerate,
    65 to WeatherState.RainHeavy,
    66 to WeatherState.FreezingRainLight,
    67 to WeatherState.FreezingRainHeavy,
    71 to WeatherState.SnowSlight,
    73 to WeatherState.SnowModerate,
    75 to WeatherState.SnowHeavy,
    77 to WeatherState.SnowGrains,
    80 to WeatherState.RainShowerSlight,
    81 to WeatherState.RainShowerModerate,
    82 to WeatherState.RainShowerViolent,
    85 to WeatherState.SnowShowerSlight,
    86 to WeatherState.SnowShowerHeavy,
    95 to WeatherState.Thunderstorm,
    96 to WeatherState.ThunderstormWithSlightHail,
    99 to WeatherState.ThunderstormWithHeavyHail
)

fun weatherCodeMapper(code: Int): WeatherState = weatherCodeMap[code] ?: WeatherState.Unknown