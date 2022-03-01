package com.hbs.koggiri.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.hbs.data.Result
import com.hbs.data.routine.RoutineRepository
import com.hbs.koggiri.mappers.toPresentation
import com.hbs.koggiri.models.HomePresentations
import com.hbs.koggiri.models.RoutineEditPresentation
import com.hbs.koggiri.models.RoutinePresentation
import com.hbs.koggiri.ui.home.state.HomeUiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

private data class HomeViewModelState(
    val home: HomePresentations? = null,
    val isLoading: Boolean = false,
    val isClickDetail: Boolean = false,
    val searchTitle: String = "",
    val routine: RoutinePresentation? = null,
    val routineEditPresentation: RoutineEditPresentation? = null
) {
    fun toUiState() = if (home == null) {
        HomeUiState.NoAssets(isLoading = isLoading)
    } else {
        if (isClickDetail) {
            if (routine == null) {
                HomeUiState.NoAssets(isLoading = isLoading)
            } else {
                HomeUiState.EditScreenUiState(
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

    fun toEditUiState() = if (routineEditPresentation != null) {
        HomeUiState.EditScreenUiState(routineEditPresentation.step)
    } else {
        HomeUiState.EditScreenUiState(0)
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

    private val _editUiState = MutableStateFlow(HomeViewModelState())
    val editUiState = _editUiState
        .map { it.toEditUiState() }
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
                routine = routine,
                routineEditPresentation = null
            )
        }
    }

    fun clickEditDoneButton(step: Int) {
        _editUiState.update {
            it.copy(routineEditPresentation = RoutineEditPresentation(step))
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