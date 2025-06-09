package com.example.weather.feature_weather.presenter.screens.weather

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateSize
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp
import com.example.weather.R
import com.example.weather.core.presenter.extensions.animatePlacement
import com.example.weather.core.presenter.extensions.toPainter

@Composable
fun AdaptiveWeatherOverview(isWeatherAreaScrolledDown: Boolean) {
    val transition = updateTransition(isWeatherAreaScrolledDown, label = "weatherTransition")
    val containerHeight by transition.animateDp(label = "height") { scrolled ->
        if (scrolled) 390.dp else 190.dp
    }
    val imageSize by transition.animateSize(label = "imageSize") { scrolled ->
        if (scrolled) Size(220f, 200f) else Size(124f, 112f)
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
                .size(imageSize.width.dp, imageSize.height.dp)
                .animatePlacement()
                .align(alignmentImage),
            modifierDetails = Modifier
                .align(alignmentDetails)
                .animatePlacement()

        )
    }
}

@Composable
private fun WeatherOverviewDisplay(
    modifierImage: Modifier,
    modifierDetails: Modifier
) {
    CurrentWeatherDetails(
        modifier = modifierDetails
            .padding(bottom = 24.dp, top = 12.dp)
    )
    Image(
        painter = R.drawable.img_mainly_clear.toPainter(),
        contentDescription = "Weather",
        modifier = modifierImage
    )
}