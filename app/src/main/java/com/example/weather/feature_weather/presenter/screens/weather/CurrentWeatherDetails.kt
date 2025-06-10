package com.example.weather.feature_weather.presenter.screens.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.core.presenter.spacer.vertical.VerticalSpacer12
import com.example.weather.ui.theme.UrbanistFontFamily

@Preview
@Composable
fun CurrentWeatherDetailsP() {
    CurrentWeatherDetails()
}

@Composable
fun CurrentWeatherDetails(
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.colorScheme
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        CurrentConditionDisplay()
        VerticalSpacer12()
        TemperatureRangeDisplay(
            modifier = Modifier
                .background(
                    color = colors.onSurface.copy(0.08f),
                    shape = RoundedCornerShape(100.dp)
                )
                .padding(horizontal = 24.dp, vertical = 8.dp),
            color = colors.surfaceVariant,
            maxTemperature = "32°C",
            minTemperature = "20°C"
        )
    }
}

@Composable
private fun CurrentConditionDisplay() {
    val colors = MaterialTheme.colorScheme
    Text(
        text = "24°C",
        fontFamily = UrbanistFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 64.sp,
        letterSpacing = 0.25.sp,
        textAlign = TextAlign.Center,
        color = colors.onSurface
    )
    Text(
        text = "Partly cloudy",
        fontFamily = UrbanistFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.25.sp,
        textAlign = TextAlign.Center,
        color = colors.onSurface.copy(alpha = 0.6f)
    )
}