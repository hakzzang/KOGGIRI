package com.hbs.koggiri.ui.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.models.CalendarFactory
import com.hbs.koggiri.models.CalendarPresentation
import com.hbs.koggiri.ui.component.KoggiriLargeTitle
import com.hbs.koggiri.ui.component.KoggiriMediumTitle
import com.hbs.koggiri.ui.component.KoggiriSmallText
import com.hbs.koggiri.ui.theme.PointBlueColor
import com.hbs.koggiri.ui.theme.PointRedColor
import org.intellij.lang.annotations.JdkConstants
import java.util.*

@Composable
fun CalendarScreenBody(
    calendarPresentations: List<CalendarPresentation>,
    onClickCalendarItem: (CalendarPresentation) -> Unit
) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CalendarContent(
            calendarPresentations,
            onClickCalendarItem
        )
    }
}

@Composable
fun CalendarContent(
    calendars: List<CalendarPresentation>,
    onClickCalendarItem: (CalendarPresentation) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
            .wrapContentHeight()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        items(calendars) {
            CalendarItem(it)
        }
    }
}

@Composable
fun CalendarItem(
    calendar: CalendarPresentation,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(64.dp)
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        if (calendar.isSelection) {
//
//        } else {
//
//        }

        val color =
            when (calendar.date.dayOfWeek.value) {
                7 -> {
                    PointRedColor
                }
                6 -> {
                    PointBlueColor
                }
                else -> {
                    Color.Black
                }
            }

        KoggiriSmallText(
            title = calendar.dayText,
            color = color,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )

        KoggiriMediumTitle(
            title = calendar.dayNumber,
            color = color,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
    }
}