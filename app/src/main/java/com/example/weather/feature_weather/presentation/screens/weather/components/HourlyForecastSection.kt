package com.example.weather.feature_weather.presentation.screens.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.core.extensions.toPainter
import com.example.weather.feature_weather.presentation.model.HourlyWeather
import com.example.weather.feature_weather.presentation.screens.weather.getWeatherStateImage
import com.example.weather.ui.theme.UrbanistFontFamily

@Composable
fun HourlyForecastSection(
    modifier: Modifier = Modifier,
    hourlyWeather: List<HourlyWeather>
) {
    SectionTitle(title = "Today")
    LazyRow(
        contentPadding = PaddingValues(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(hourlyWeather) {
            HourlyWeatherItem(
                modifier = modifier,
                temperature = it.temperature,
                time = it.time,
                weatherImage = it.weatherState.getWeatherStateImage(it.isDay).toPainter()
            )
        }
    }
}

@Composable
private fun HourlyWeatherItem(
    modifier: Modifier,
    temperature: String,
    time: String,
    weatherImage: Painter
) {
    val colors = MaterialTheme.colorScheme
    Box(
        modifier = Modifier
            .height(138.dp)
    ) {
        Column(
            modifier = modifier
                .width(100.dp)
                .background(
                    color = colors.surfaceContainer.copy(0.7f),
                    shape = RoundedCornerShape(20.dp)
                )
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(20.dp),
                    color = colors.onSurface.copy(0.08f)
                )
                .align(Alignment.BottomCenter)
                .padding(top = 52.dp, bottom = 16.dp, start = 12.dp, end = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = temperature,
                fontFamily = UrbanistFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
                color = colors.onSurface.copy(alpha = 0.87f),
                modifier = Modifier.padding(top = 8.dp, bottom = 2.dp)
            )
            Text(
                text = time,
                fontFamily = UrbanistFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
                color = colors.onSurface.copy(alpha = 0.6f)
            )
        }
        Image(
            painter = weatherImage,
            contentDescription = null,
            modifier = Modifier
                .height(58.dp)
//                        .dropShadow(
//                            color = Color1D2646.copy(alpha = 0.25f),
//                            offsetX = -(21).dp,
//                            offsetY = 15.dp,
//                            blurRadius = 50.dp
//                        )
                .align(Alignment.TopCenter)
        )
    }
}