package com.example.weather.feature_weather.presentation.screens.weather.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import com.example.weather.ui.theme.Color87CEFA
import com.example.weather.ui.theme.UrbanistFontFamily

@Composable
fun WeatherInfoItem(modifier: Modifier = Modifier, painter: Painter, value: String, title: String) {
    val colors = MaterialTheme.colorScheme
    Column(
        modifier = modifier
            .background(
                color = colors.surfaceContainer.copy(0.7f),
                shape = RoundedCornerShape(24.dp)
            )
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(24.dp),
                color = colors.onSurface.copy(0.08f)
            )
            .padding(horizontal = 8.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = Color87CEFA,
            modifier = Modifier.size(32.dp)
        )

        Text(
            text = value,
            fontFamily = UrbanistFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            color = colors.onSurface.copy(alpha = 0.87f),
            modifier = Modifier.padding(top = 8.dp, bottom = 2.dp)
        )
        Text(
            text = title,
            fontFamily = UrbanistFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            color = colors.onSurface.copy(alpha = 0.6f)
        )
    }
}