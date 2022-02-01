package com.hbs.koggiri.ui.history

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hbs.koggiri.models.CalendarPresentation
import com.hbs.koggiri.ui.component.getCardModifier
import com.hbs.koggiri.ui.history.component.CalendarContent

@Composable
fun CalendarScreenBody(
    calendarPresentations: List<CalendarPresentation>,
    onClickCalendarItem: (CalendarPresentation) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    CalendarContent(
        calendars = calendarPresentations,
        onClickCalendarItem = onClickCalendarItem,
        modifier = Modifier.getCardModifier()
    )
}