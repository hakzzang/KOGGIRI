package com.hbs.koggiri.ui.home.routine

import androidx.compose.runtime.Composable
import com.hbs.koggiri.ui.home.HomeUiState

@Composable
fun RoutineEditScreen(
    uiState: HomeUiState,
    title: String
) {
    if (uiState is HomeUiState.NoAssets) {
        return
    }
    val assets = uiState

}