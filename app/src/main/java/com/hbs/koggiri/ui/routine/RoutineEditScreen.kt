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
        uiState = null,
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
    if(uiState is HomeUiState.EditScreenUiState) {
        RoutineEditContents(
            title = title,
            subtitle = subtitle,
            uiState = uiState,
            onClickEditDoneButton = onClickEditDoneButton
        )
    }
}