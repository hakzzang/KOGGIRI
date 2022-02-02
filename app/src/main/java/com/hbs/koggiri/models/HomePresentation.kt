package com.hbs.koggiri.models

data class HomePresentations(
    val routinePresentation: List<RoutinePresentation>
)

data class RoutinePresentation(
    val title: String,
    val memo: String,
    val completedCount: Int,
    val isCompletedToday: Boolean
)
