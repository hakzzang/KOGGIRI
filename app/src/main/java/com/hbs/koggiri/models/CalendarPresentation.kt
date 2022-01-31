package com.hbs.koggiri.models

import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

data class CalendarPresentation(
    val dayText: String,
    val dayNumber: String,
    val date: LocalDate,
    val isSelection: Boolean
)

object CalendarFactory {
    private const val CALENDAR_SIZE = 31L

    fun getCalendarPresentations(): List<CalendarPresentation> {
        val resourceDate = LocalDate.now().minusDays(CALENDAR_SIZE)
        return (0..CALENDAR_SIZE * 2).map { addToDays -> presentationOf(resourceDate, addToDays) }
            .toList()
    }

    private fun presentationOf(
        resourceDate: LocalDate,
        addToDays: Long
    ): CalendarPresentation {
        val targetDate = resourceDate.plusDays(addToDays)
        val dayOfMonth = targetDate.dayOfMonth
        val dayOfWeek = targetDate.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREA)

        return CalendarPresentation(
            dayText = dayOfWeek,
            dayNumber = dayOfMonth.toString(),
            date = targetDate,
            isSelection = false,
        )
    }

}