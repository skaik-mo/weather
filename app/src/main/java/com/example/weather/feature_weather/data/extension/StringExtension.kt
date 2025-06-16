package com.example.weather.feature_weather.data.extension

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.toHourFormat(): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val outputFormatter = DateTimeFormatter.ofPattern("hh:mm a")
    return runCatching {
        LocalDateTime.parse(this, inputFormatter).format(outputFormatter)
    }.getOrElse { "" }
}