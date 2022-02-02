package com.hbs.domain.home.routine

data class Routine(
    val title: String,
    val memo: String,
    val completeDates: List<RoutineComplete>
) {
    val lastCompleteDate : String get() {
        return completeDates.last().date
    }
}

data class RoutineComplete(
    val date: String
)