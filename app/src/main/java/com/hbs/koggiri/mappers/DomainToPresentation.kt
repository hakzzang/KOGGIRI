package com.hbs.koggiri.mappers

import com.hbs.domain.home.routine.Routine
import com.hbs.koggiri.extensions.isToday
import com.hbs.koggiri.models.RoutinePresentation

internal fun Routine.toPresentation(): RoutinePresentation {
    return RoutinePresentation(
        title = title,
        memo = memo,
        completedCount = completeDates.count(),
        isCompletedToday = lastCompleteDate.isToday()
    )
}