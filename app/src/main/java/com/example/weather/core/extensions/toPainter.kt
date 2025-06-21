package com.example.weather.core.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Composable
fun Int.toPainter(): Painter = painterResource(this)