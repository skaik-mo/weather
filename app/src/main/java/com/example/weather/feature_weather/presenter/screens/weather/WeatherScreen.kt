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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.core.presenter.extensions.toPainter
import com.example.weather.ui.theme.UrbanistFontFamily
import com.example.weather.ui.theme.WeatherTheme

@Composable
fun WeatherScreen() {
    WeatherContent()
}

@Composable
private fun WeatherContent(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberLazyListState()
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
    ) {
        item {
            HeaderView(modifier = Modifier.padding(top = 24.dp))
        }
        item {
            AdaptiveWeatherOverview(isWeatherAreaScrolledDown = isWeatherAreaScrolledDown)
        }
        item {
            WeatherInfoGrid()
        }
        item {
            HourlyForecastSection()
        }
        item {
            DailyForecastSection()
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun WeatherContentPreview() {
    WeatherTheme(darkTheme = false) {
        WeatherContent()
    }
}