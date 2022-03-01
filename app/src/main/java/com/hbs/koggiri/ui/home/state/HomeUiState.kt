package com.hbs.koggiri.ui.home.state

import com.hbs.koggiri.models.RoutinePresentation

sealed interface HomeUiState {
    val isLoading: Boolean

    data class NoAssets(
        override val isLoading: Boolean = true
    ) : HomeUiState

    data class HasAssets(
        val routines: List<RoutinePresentation>,
        override val isLoading: Boolean = false
    ) : HomeUiState

    data class EditScreenUiState(
        val step: Int = 0,
        override val isLoading: Boolean = false
    ) : HomeUiState
}