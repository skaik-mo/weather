package com.example.weather.feature_weather.presenter.extenstion

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Composable
fun Int.toPainter(): Painter = painterResource(this)