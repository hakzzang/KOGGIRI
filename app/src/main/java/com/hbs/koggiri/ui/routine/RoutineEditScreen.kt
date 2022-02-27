package com.hbs.koggiri.ui.routine

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewEditScreen() {
    RoutineEditScreen(
        title = "What are you goals?",
        subtitle = "Select all that apply"
    )
}
@Composable
fun RoutineEditScreen(
    title: String,
    subtitle: String
) {
    RoutineEditContents(
        title = title,
        subtitle = subtitle
    )
}