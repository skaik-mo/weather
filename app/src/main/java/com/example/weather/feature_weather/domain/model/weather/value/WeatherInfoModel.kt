package com.example.weather.feature_weather.domain.model.weather.value

import com.example.weather.feature_weather.domain.model.weather.unit.CurrentWeatherUnits
import com.example.weather.feature_weather.domain.model.weather.unit.DailyWeatherUnits
import com.example.weather.feature_weather.domain.model.weather.unit.HourlyWeatherUnits

data class WeatherInfoModel(
    val currentWeatherModel: CurrentWeatherModel,
    val currentWeatherUnits: CurrentWeatherUnits,
    val hourlyWeatherModels: List<HourlyWeatherModel>,
    val hourlyWeatherUnits: HourlyWeatherUnits,
    val dailyWeatherModels: List<DailyWeatherModel>,
    val dailyWeatherUnits: DailyWeatherUnits,
) {
    constructor() : this(
        currentWeatherModel = CurrentWeatherModel(),
        currentWeatherUnits = CurrentWeatherUnits(),
        hourlyWeatherModels = emptyList(),
        hourlyWeatherUnits = HourlyWeatherUnits(),
        dailyWeatherModels = emptyList(),
        dailyWeatherUnits = DailyWeatherUnits(),
    )
}