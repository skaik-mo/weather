package com.example.weather.feature_weather.presentation.screens.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.core.extensions.toDayName
import com.example.weather.core.extensions.toPainter
import com.example.weather.feature_weather.presentation.model.CurrentWeather
import com.example.weather.feature_weather.presentation.model.DailyWeather
import com.example.weather.feature_weather.presentation.screens.weather.getWeatherStateImage
import com.example.weather.ui.theme.UrbanistFontFamily
import kotlin.collections.forEachIndexed

@Composable
fun DailyForecastSection(
    dailyWeather: List<DailyWeather>,
    currentWeather: CurrentWeather
) {
    val colors = MaterialTheme.colorScheme
    SectionTitle(title = "Next 7 days")
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .padding(bottom = 32.dp)
            .border(
                width = 1.dp,
                color = colors.onSurface.copy(alpha = 0.08f),
                shape = RoundedCornerShape(24.dp)
            )
            .background(
                color = colors.surfaceContainer.copy(alpha = 0.7f),
                shape = RoundedCornerShape(24.dp)
            )
    ) {
        dailyWeather.forEachIndexed { index, daily ->
            DailyForecastItem(
                showDivider = dailyWeather.size - 1 != index,
                dayOfWeek = daily.date.toDayName(),
                weatherImage = daily.weatherState.getWeatherStateImage(currentWeather.isDay)
                    .toPainter(),
                maxTemperature = daily.maxTemperature,
                minTemperature = daily.minTemperature,
            )
        }
    }
}

@Composable
private fun DailyForecastItem(
    showDivider: Boolean = true, dayOfWeek: String, weatherImage: Painter, maxTemperature: String,
    minTemperature: String
) {
    val colors = MaterialTheme.colorScheme
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 14.dp, horizontal = 16.dp)
    ) {
        Text(
            text = dayOfWeek,
            fontFamily = UrbanistFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            color = colors.onSurface.copy(alpha = 0.6f),
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = weatherImage,
            contentDescription = null,
            modifier = Modifier.weight(1f).height(32.dp)
        )
        TemperatureRangeDisplay(
            color = colors.onSurface.copy(0.87f),
            maxTemperature = maxTemperature,
            minTemperature = minTemperature,
        )
    }
    if (showDivider)
        Divider(
            color = colors.onSurface.copy(alpha = 0.08f),
        )
}