package com.example.weather.feature_weather.presentation.screens.weather.components

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.weather.core.extensions.animatePlacement
import com.example.weather.core.extensions.dropShadow
import com.example.weather.ui.theme.Color1D2646

@Composable
fun AdaptiveWeatherOverview(
    isWeatherAreaScrolledDown: Boolean,
    temperature: String,
    weatherStatus: String,
    maxTemperature: String,
    minTemperature: String,
    weatherImage: Painter,
) {
    val transition = updateTransition(isWeatherAreaScrolledDown, label = "weatherTransition")
    val containerHeight by transition.animateDp(label = "height") { scrolled ->
        if (scrolled) 390.dp else 190.dp
    }
    val imageHeight by transition.animateDp(label = "height") { scrolled ->
        if (scrolled) 200.dp else 112.dp
    }
    var alignmentImage =
        if (isWeatherAreaScrolledDown) Alignment.TopCenter else Alignment.CenterStart
    var alignmentDetails =
        if (isWeatherAreaScrolledDown) Alignment.BottomCenter else Alignment.CenterEnd
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(containerHeight)
    ) {
        WeatherOverviewDisplay(
            modifierImage = Modifier
                .padding(horizontal = 12.dp)
                .height(imageHeight)
                .animatePlacement()
                .align(alignmentImage),
            modifierDetails = Modifier
                .padding(horizontal = 12.dp)
                .align(alignmentDetails)
                .animatePlacement(),
            temperature = temperature,
            weatherStatus = weatherStatus,
            maxTemperature = maxTemperature,
            minTemperature = minTemperature,
            weatherImage = weatherImage,
        )
    }
}

@Composable
private fun WeatherOverviewDisplay(
    modifierImage: Modifier,
    modifierDetails: Modifier,
    temperature: String,
    weatherStatus: String,
    maxTemperature: String,
    minTemperature: String,
    weatherImage: Painter,
) {
    CurrentWeatherDetails(
        modifier = modifierDetails
            .padding(bottom = 24.dp, top = 12.dp),
        temperature = temperature,
        weatherStatus = weatherStatus,
        maxTemperature = maxTemperature,
        minTemperature = minTemperature
    )
    Image(
        painter = weatherImage,
        contentDescription = "Weather",
        modifier = modifierImage
            .dropShadow(
                color = Color1D2646.copy(alpha = 0.25f),
                offsetX = -(21).dp,
                offsetY = 40.dp,
                blurRadius = 100.dp
            )
    )
}