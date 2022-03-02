package com.hbs.koggiri.ui.routine

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hbs.koggiri.ui.home.state.HomeUiState

@Preview
@Composable
fun PreviewEditScreen() {
    RoutineEditScreen(
        title = "What are you goals?",
        subtitle = "Select all that apply",
        onClickEditDoneButton = {}
    )
}

@Composable
fun RoutineEditScreen(
    title: String,
    subtitle: String,
    uiState: HomeUiState? = null,
    onClickEditDoneButton: ((Int) -> Unit)
) {
    if (uiState is HomeUiState.EditScreenUiState) {
        if (uiState.step == 0) {
            SelectionRoutineContents(
                title = title,
                subtitle = subtitle,
                onClickEditDoneButton = onClickEditDoneButton
            )
        } else if (uiState.step == 1) {
            CounterRoutineContents(
                uiState = uiState,
                title = title,
                subtitle = subtitle,
                onClickEditDoneButton = onClickEditDoneButton
            )
        }

    }
}