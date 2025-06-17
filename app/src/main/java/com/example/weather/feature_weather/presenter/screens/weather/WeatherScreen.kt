package com.example.weather.feature_weather.presenter.screens.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather.core.presenter.extensions.toPainter
import com.example.weather.feature_weather.presenter.screens.weather.components.AdaptiveWeatherOverview
import com.example.weather.feature_weather.presenter.screens.weather.components.DailyForecastSection
import com.example.weather.feature_weather.presenter.screens.weather.components.HeaderView
import com.example.weather.feature_weather.presenter.screens.weather.components.HourlyForecastSection
import com.example.weather.feature_weather.presenter.screens.weather.components.WeatherInfoGrid
import com.example.weather.ui.theme.WeatherTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherScreen(
    weatherViewModel: WeatherViewModel = koinViewModel()
) {
    val state by weatherViewModel.state.collectAsState()
    WeatherTheme(darkTheme = !state.weatherInfo.currentWeather.isDay) {
        when {
            state.isLoading -> LoadingView()
            state.errorModel.isError -> ErrorView(errorMessage = state.errorModel.exception.message)
            else -> WeatherContent(state = state)
        }
    }
}

@Composable
private fun WeatherContent(
    state: WeatherUiState,
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
            HeaderView(modifier = Modifier.padding(top = 24.dp, bottom = 8.dp))
        }
        item {
            AdaptiveWeatherOverview(
                isWeatherAreaScrolledDown = isWeatherAreaScrolledDown,
                temperature = state.weatherInfo.currentWeather.currentTemperature,
                weatherStatus = state.weatherInfo.currentWeather.weatherState.description,
                maxTemperature = state.maxTemperature,
                minTemperature = state.minTemperature,
                weatherImage = state.weatherImage.toPainter(),
            )
        }
        item {
            WeatherInfoGrid(weatherInfoItems = state.weatherInfoItems)
        }
        item {
            HourlyForecastSection(
                hourlyWeather = state.weatherInfo.hourlyWeathers
            )
        }
        item {
            DailyForecastSection(
                dailyWeather = state.weatherInfo.dailyWeathers,
                currentWeather = state.weatherInfo.currentWeather
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun WeatherContentPreview(
    weatherViewModel: WeatherViewModel = koinViewModel()
) {
    val state by weatherViewModel.state.collectAsState()
    WeatherTheme(darkTheme = false) {
        WeatherContent(state)
    }
}