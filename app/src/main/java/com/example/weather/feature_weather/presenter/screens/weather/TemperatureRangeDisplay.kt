package com.example.weather.feature_weather.presenter.screens.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weather.R
import com.example.weather.core.presenter.extensions.toPainter

@Composable
fun TemperatureRangeDisplay(
    modifier: Modifier = Modifier, color: Color, maxTemperature: String, minTemperature: String
) {
    val colors = MaterialTheme.colorScheme
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        IconWithText(
            icon = R.drawable.ic_arrow_up.toPainter(),
            text = maxTemperature,
            color = color
        )
        Box(
            modifier = Modifier
                .width(1.dp)
                .height(14.dp)
                .background(colors.onSurface.copy(0.24f))
        )
        IconWithText(
            icon = R.drawable.ic_arrow_down.toPainter(),
            text = minTemperature,
            color = color
        )
    }
}