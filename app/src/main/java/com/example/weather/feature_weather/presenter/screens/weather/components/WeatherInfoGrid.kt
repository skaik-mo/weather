package com.example.weather.feature_weather.presenter.screens.weather.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather.R
import com.example.weather.core.presenter.extensions.toPainter
import com.example.weather.feature_weather.presenter.model.WeatherInfoItemModel


@Composable
fun WeatherInfoGrid(
    weatherInfoItems: List<WeatherInfoItemModel>
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 115.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        contentPadding = PaddingValues(horizontal = 12.dp),
        modifier = Modifier
            .height(260.dp)
            .wrapContentHeight(),
        userScrollEnabled = false
    ) {
        items(weatherInfoItems) {
            WeatherInfoItem(
                modifier = Modifier,
                painter = it.image.toPainter(),
                value = it.value,
                title = it.title
            )
        }
    }
}

@Preview()
@Composable
fun WeatherInfoGridPreview() {
    WeatherInfoGrid(
        weatherInfoItems = listOf(
            WeatherInfoItemModel(
                image = R.drawable.img_weather_fog_day,
                value = "10",
                title = "title"
            )
        )
    )
}