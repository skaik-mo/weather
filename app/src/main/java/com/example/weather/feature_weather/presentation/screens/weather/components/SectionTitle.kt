package com.example.weather.feature_weather.presentation.screens.weather.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.UrbanistFontFamily

@Composable
fun SectionTitle(modifier: Modifier = Modifier, title: String) {
    val colors = MaterialTheme.colorScheme
    Text(
        text = title,
        fontFamily = UrbanistFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        letterSpacing = 0.25.sp,
        textAlign = TextAlign.Center,
        color = colors.onSurface,
        modifier = modifier.padding(top = 24.dp, bottom = 12.dp, start = 12.dp)
    )
}