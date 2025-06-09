package com.example.weather.feature_weather.presenter.screens.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.core.presenter.extensions.toPainter
import com.example.weather.core.presenter.spacer.vertical.VerticalSpacer12
import com.example.weather.ui.theme.UrbanistFontFamily

@Composable
fun CurrentWeatherDetails(
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.colorScheme
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        CurrentConditionDisplay(colors)
        VerticalSpacer12()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .background(
                    color = colors.onSurface.copy(0.08f),
                    shape = RoundedCornerShape(100.dp)
                )
                .padding(horizontal = 24.dp, vertical = 8.dp)
        ) {
            IconWithText(
                icon = R.drawable.ic_arrow_up.toPainter(),
                text = "32°C"
            )
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(14.dp)
                    .background(colors.onSurface.copy(0.24f))
            )
            IconWithText(
                icon = R.drawable.ic_arrow_down.toPainter(),
                text = "20°C"
            )
        }
    }
}

@Composable
private fun CurrentConditionDisplay(colors: ColorScheme) {
    Text(
        text = "24°C",
        fontFamily = UrbanistFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 64.sp,
        letterSpacing = 0.25.sp,
        textAlign = TextAlign.Center,
        color = colors.onSurface
    )
    Text(
        text = "Partly cloudy",
        fontFamily = UrbanistFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.25.sp,
        textAlign = TextAlign.Center,
        color = colors.onSurface.copy(alpha = 0.6f)
    )
}


@Composable
private fun IconWithText(icon: Painter, text: String) {
    val colors = MaterialTheme.colorScheme
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Icon(
            painter = icon,
            contentDescription = "Arrow",
            tint = colors.surfaceVariant,
            modifier = Modifier.size(12.dp)
        )
        Text(
            text = text,
            fontFamily = UrbanistFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            color = colors.surfaceVariant
        )
    }
}