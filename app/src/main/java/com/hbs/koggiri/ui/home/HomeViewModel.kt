package com.hbs.koggiri.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.hbs.data.Result
import com.hbs.data.routine.RoutineRepository
import com.hbs.koggiri.mappers.toPresentation
import com.hbs.koggiri.models.HomePresentations
import com.hbs.koggiri.models.RoutinePresentation
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

sealed interface HomeUiState {
    val isLoading: Boolean

    data class NoAssets(
        override val isLoading: Boolean = true
    ) : HomeUiState

    data class HasAssets(
        val routines: List<RoutinePresentation>,
        override val isLoading: Boolean = false
    ) : HomeUiState

    data class HasDetailAssets(
        val routines: List<RoutinePresentation> = emptyList(),
        val routine: RoutinePresentation,
        override val isLoading: Boolean = false
    ) : HomeUiState
}

private data class HomeViewModelState(
    val home: HomePresentations? = null,
    val isLoading: Boolean = false,
    val isClickDetail: Boolean = false,
    val searchTitle: String = "",
    val routine: RoutinePresentation? = null
) {
    fun toUiState() = if (home == null) {
        HomeUiState.NoAssets(isLoading = isLoading)
    } else {
        if (isClickDetail) {
            if (routine == null) {
                HomeUiState.NoAssets(isLoading = isLoading)
            } else {
                HomeUiState.HasDetailAssets(
                    routines = home.routinePresentations,
                    routine = routine,
                    isLoading = isLoading
                )
            }
        } else {
            HomeUiState.HasAssets(
                routines = home.routinePresentations,
                isLoading = isLoading
            )
        }
    }
}

class HomeViewModel(
    private val routineRepository: RoutineRepository
) : ViewModel() {
    private val viewModelState = MutableStateFlow(HomeViewModelState())
    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        refreshAssets()
    }

    fun refreshAssets() {
        viewModelState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = routineRepository.getRoutines()
            viewModelState.update { state ->
                when (result) {
                    is Result.Success -> {
                        val homeData = HomePresentations(result.data.map { it.toPresentation() })
                        state.copy(home = homeData, isLoading = false)
                    }
                    is Result.Error -> state.copy(isLoading = true)
                }
            }
        }
    }

    fun clickRoutineContent(routine: RoutinePresentation) {
        viewModelState.update {
            it.copy(
                searchTitle = routine.title,
                isClickDetail = true,
                routine = routine
            )
        }
    }

    companion object {
        fun provideFactory(
            routineRepository: RoutineRepository
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeViewModel(routineRepository) as T
            }
        }
    }
}