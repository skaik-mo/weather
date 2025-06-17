package com.example.weather.feature_weather.presenter.screens.weather

import com.example.weather.R
import com.example.weather.core.presenter.extensions.toLocalDate
import com.example.weather.feature_weather.domain.model.Location
import com.example.weather.feature_weather.domain.model.WeatherInfo
import com.example.weather.feature_weather.domain.model.WeatherState
import com.example.weather.feature_weather.presenter.model.ErrorModel
import com.example.weather.feature_weather.presenter.model.WeatherInfoItemModel
import java.time.LocalDate

data class WeatherUiState(
    val location: Location = Location(),
    val weatherInfo: WeatherInfo = WeatherInfo(),
    var errorModel: ErrorModel = ErrorModel(),
    var isLoading: Boolean = true,
) {
    val weatherImage =
        weatherInfo.currentWeather.weatherState.getWeatherStateImage(isDay = weatherInfo.currentWeather.isDay)
    val weatherToday =
        weatherInfo.dailyWeathers.firstOrNull { it.date.toLocalDate() == LocalDate.now() }
    val maxTemperature = weatherToday?.maxTemperature ?: "0.0"
    val minTemperature = weatherToday?.minTemperature ?: "0.0"
    val weatherInfoItems = listOf<WeatherInfoItemModel>(
        WeatherInfoItemModel(
            image = R.drawable.ic_fast_wind,
            value = weatherInfo.currentWeather.windSpeed,
            title = "Wind"
        ),
        WeatherInfoItemModel(
            image = R.drawable.ic_humidity,
            value = weatherInfo.currentWeather.humidity,
            title = "Humidity"
        ),
        WeatherInfoItemModel(
            image = R.drawable.ic_rain,
            value = weatherInfo.currentWeather.rain,
            title = "Rain"
        ),
        WeatherInfoItemModel(
            image = R.drawable.ic_uv_index,
            value = weatherInfo.currentWeather.uvIndex,
            title = "UV Index"
        ),
        WeatherInfoItemModel(
            image = R.drawable.ic_arrow_down_blue,
            value = weatherInfo.currentWeather.pressure,
            title = "Pressure"
        ),
        WeatherInfoItemModel(
            image = R.drawable.ic_temperature,
            value = weatherInfo.currentWeather.apparentTemperature,
            title = "Feels like"
        )
    )
}

fun WeatherState.getWeatherStateImage(isDay: Boolean): Int {
    var weatherStateImages = when (this) {
        WeatherState.ClearSky -> Pair(R.drawable.img_clear_sky_day, R.drawable.img_clear_sky_night)
        WeatherState.MainlyClear -> Pair(
            R.drawable.img_mainly_clear_day,
            R.drawable.img_mainly_clear_nghit
        )

        WeatherState.PartlyCloudy -> Pair(
            R.drawable.img_partly_cloudy_day,
            R.drawable.img_partly_cloudy_night
        )

        WeatherState.Overcast -> Pair(R.drawable.img_overcast, R.drawable.img_overcast)
        WeatherState.Fog -> Pair(R.drawable.img_weather_fog_day, R.drawable.img_weather_fog_night)
        WeatherState.DepositingRimeFog -> Pair(
            R.drawable.img_depositing_rime_fog,
            R.drawable.img_depositing_rime_fog
        )

        WeatherState.DrizzleLight -> Pair(
            R.drawable.img_drizzle_day,
            R.drawable.img_weather_fog_night
        )

        WeatherState.DrizzleModerate -> Pair(
            R.drawable.img_drizzle_moderate_day,
            R.drawable.img_drizzle_moderate_night
        )

        WeatherState.DrizzleDense -> Pair(
            R.drawable.img_drizzle_intensity_day,
            R.drawable.img_drizzle_intensity_night
        )

        WeatherState.FreezingDrizzleLight -> Pair(
            R.drawable.img_freezing_drizzle_light,
            R.drawable.img_freezing_drizzle_light
        )

        WeatherState.FreezingDrizzleDense -> Pair(
            R.drawable.img_freezing_drizzle_intensity,
            R.drawable.img_freezing_drizzle_intensity
        )

        WeatherState.RainSlight -> Pair(
            R.drawable.img_rain_slight_day,
            R.drawable.img_rain_slight_night
        )

        WeatherState.RainModerate -> Pair(
            R.drawable.img_rain_moderate_day,
            R.drawable.img_rain_moderate_night
        )

        WeatherState.RainHeavy -> Pair(
            R.drawable.img_rain_intensity_day,
            R.drawable.img_rain_intensity_night
        )

        WeatherState.FreezingRainLight -> Pair(
            R.drawable.img_freezing_rain_light,
            R.drawable.img_freezing_rain_light
        )

        WeatherState.FreezingRainHeavy -> Pair(
            R.drawable.img_freezing_rain_intensity,
            R.drawable.img_freezing_rain_intensity
        )

        WeatherState.SnowSlight -> Pair(
            R.drawable.img_snow_fall_light_day,
            R.drawable.img_snow_fall_light_night
        )

        WeatherState.SnowModerate -> Pair(
            R.drawable.img_snow_fall_moderate_day,
            R.drawable.img_snow_fall_moderate_day
        )

        WeatherState.SnowHeavy -> Pair(
            R.drawable.img_snow_fall_intensity,
            R.drawable.img_snow_fall_intensity
        )

        WeatherState.SnowGrains -> Pair(
            R.drawable.img_snow_grains_day,
            R.drawable.img_snow_grains_day
        )

        WeatherState.RainShowerSlight -> Pair(
            R.drawable.img_rain_shower_slight_day,
            R.drawable.img_rain_shower_slight_night
        )

        WeatherState.RainShowerModerate -> Pair(
            R.drawable.img_rain_shower_moderate_day,
            R.drawable.img_rain_shower_moderate_night
        )

        WeatherState.RainShowerViolent -> Pair(
            R.drawable.img_rain_shower_violent_day,
            R.drawable.img_rain_shower_violent_night
        )

        WeatherState.SnowShowerSlight -> Pair(
            R.drawable.img_snow_grains_day,
            R.drawable.img_snow_grains_night
        )

        WeatherState.SnowShowerHeavy -> Pair(
            R.drawable.img_snow_shower_heavy_day,
            R.drawable.img_snow_shower_heavy_night
        )

        WeatherState.Thunderstorm -> Pair(
            R.drawable.img_thunderstorm_slight,
            R.drawable.img_thunderstorm_slight
        )

        WeatherState.ThunderstormWithSlightHail -> Pair(
            R.drawable.img_thunderstorm_with_slight,
            R.drawable.img_thunderstorm_with_slight
        )

        WeatherState.ThunderstormWithHeavyHail -> Pair(
            R.drawable.img_thunderstorm_with_heavy_day,
            R.drawable.img_thunderstorm_with_heavy_day
        )

        WeatherState.Unknown -> Pair(R.drawable.img_clear_sky_day, R.drawable.img_clear_sky_night)
    }
    return if (isDay) weatherStateImages.first else weatherStateImages.second
}