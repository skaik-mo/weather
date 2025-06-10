package com.example.weather.feature_weather.presenter.screens.weather

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
import com.example.weather.R
import com.example.weather.core.presenter.extensions.toPainter
import com.example.weather.ui.theme.UrbanistFontFamily

@Composable
fun DailyForecastSection() {
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
        (1..<8).toList().forEach { value ->
            DailyForecastItem(
                showDivider = value != 7,
                dayOfWeek = "Day",
                weatherIcon = R.drawable.img_clear_sky.toPainter()
            )
        }
    }
}

@Composable
private fun DailyForecastItem(
    showDivider: Boolean = true, dayOfWeek: String, weatherIcon: Painter
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
            color = colors.onSurface.copy(alpha = 0.6f)
        )
        Image(
            painter = weatherIcon,
            contentDescription = null,
            modifier = Modifier.height(32.dp)
        )
        TemperatureRangeDisplay(
            color = colors.onSurface.copy(0.87f),
            maxTemperature = "32°C",
            minTemperature = "20°C"
        )
    }
    if (showDivider)
        Divider(
            color = colors.onSurface.copy(alpha = 0.08f),
        )
}