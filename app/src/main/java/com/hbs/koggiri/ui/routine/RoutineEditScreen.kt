package com.hbs.koggiri.ui.routine

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hbs.koggiri.ui.home.state.HomeUiState

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
    subtitle: String,
    uiState: HomeUiState.HasDetailAssets? = null
) {
    RoutineEditContents(
        title = title,
        subtitle = subtitle,
        uiState = uiState
    )
}