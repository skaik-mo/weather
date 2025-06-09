package com.example.weather.feature_weather.presenter.screens.weather

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather.R
import com.example.weather.core.presenter.extensions.toPainter
import com.example.weather.ui.theme.WeatherTheme

@Composable
fun WeatherScreen() {
    WeatherContent()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable

private fun WeatherContent(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberLazyListState()

// Check if scrolled to top
    val isWeatherAreaScrolledDown by remember {
        derivedStateOf {
            scrollState.firstVisibleItemIndex == 0 &&
                    scrollState.firstVisibleItemScrollOffset == 0
        }
    }
    val colors = MaterialTheme.colorScheme

    LazyColumn(
        state = scrollState,
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colors.background,
                        colors.onBackground
                    )
                )
            )
            .statusBarsPadding()
            .padding(top = 24.dp)
    ) {
        item {
            HeaderView()
        }
        stickyHeader {
            Crossfade(
                targetState = isWeatherAreaScrolledDown,
                animationSpec = tween(3000)
            ) {
                AdaptiveWeatherOverview(isWeatherAreaScrolledDown = it)
            }
        }
        item {
            Column(
                modifier = Modifier
                    .height(5000.dp)
                    .fillMaxWidth()
                    .background(Color.Blue)
            ) {
                Text("dskcdm")
            }
        }
    }
}

@Composable
private fun AdaptiveWeatherOverview(isWeatherAreaScrolledDown: Boolean) {
    if (isWeatherAreaScrolledDown) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            WeatherOverviewDisplay(Modifier.size(width = 220.dp, height = 200.dp))
        }
    } else {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            WeatherOverviewDisplay(Modifier.size(width = 124.dp, height = 112.dp))
        }
    }
}

@Composable
private fun WeatherOverviewDisplay(modifierImage: Modifier) {
    Image(
        painter = R.drawable.img_mainly_clear.toPainter(),
        contentDescription = "Weather",
        modifier = modifierImage
    )
    CurrentWeatherDetails()
}

@Preview(showSystemUi = true)
@Composable
fun WeatherContentPreview() {
    WeatherTheme(darkTheme = false) {
        WeatherContent()
    }
}