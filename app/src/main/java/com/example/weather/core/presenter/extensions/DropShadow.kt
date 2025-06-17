package com.example.weather.core.presenter.extensions

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.dropShadow(
    color: Color = Color.Black.copy(alpha = 0.25f),
    offsetX: Dp = 0.dp,
    offsetY: Dp = 4.dp,
    blurRadius: Dp = 8.dp
) = this.drawBehind {
    val transparentColor = Color.Transparent.toArgb()
    val shadowColor = color.toArgb()
    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            blurRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            12.dp.toPx(),
            12.dp.toPx(),
            paint
        )
    }
}