package com.hbs.koggiri.extensions

import java.time.LocalDate


fun String.isToday(): Boolean {
    val today = LocalDate.now()
    val comparedDay = this.toLocalDate()

    val result = today?.compareTo(comparedDay)
    return result == 0
}

fun String.toLocalDate(): LocalDate? {
    return LocalDate.parse(this)
}