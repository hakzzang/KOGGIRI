package com.hbs.koggiri.extensions

import java.time.LocalDate


fun String.isToday(): Boolean {
    val today = LocalDate.now()
    val comparedDay = this.toLocalDate()

    val result = today?.compareTo(comparedDay)
    return result == 0
}

fun String.toLocalDate(): LocalDate? {
    if(isNullOrEmpty()) {
        return LocalDate.of(2000,1,1)
    }
    return LocalDate.parse(this)
}