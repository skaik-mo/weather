package com.example.weather.core.extensions

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

fun String.toHourFormat(): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val outputFormatter = DateTimeFormatter.ofPattern("hh:mm a")
    return runCatching {
        LocalDateTime.parse(this, inputFormatter).format(outputFormatter)
    }.getOrElse { "" }
}

fun String.toLocalDate(pattern: String = "yyyy-MM-dd"): LocalDate {
    val formatter = DateTimeFormatter.ofPattern(pattern)
    return LocalDate.parse(this, formatter)
}

fun String.toDayName(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val date = LocalDate.parse(this, formatter)
    return date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
}