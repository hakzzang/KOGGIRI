package com.hbs.koggiri.ui.home

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.hbs.koggiri.models.RoutinePresentation
import com.hbs.koggiri.ui.home.state.HomeUiState
import com.hbs.koggiri.ui.routine.RoutineEditScreen

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    val uiState by homeViewModel.uiState.collectAsState()
    val editUiState by homeViewModel.editUiState.collectAsState()
    HomeRoute(
        uiState = uiState,
        editUiState = editUiState,
        onClickRoutineContent = { routine ->
            homeViewModel.clickRoutineContent(routine)
        },
        onClickGreetingContent = { },
        onClickGreetingEdit = { },
        onCompleteHomeDetail = { },
        onClickEditDoneButton = { step -> homeViewModel.clickEditDoneButton(step) },
        scaffoldState = scaffoldState
    )
}

@Composable
fun HomeRoute(
    uiState: HomeUiState,
    editUiState : HomeUiState,
    onClickGreetingContent: (String) -> Unit,
    onClickGreetingEdit: (String) -> Unit,
    onClickRoutineContent: (RoutinePresentation) -> Unit,
    onCompleteHomeDetail: (Boolean) -> Unit,
    onClickEditDoneButton: ((Int) -> Unit),
    scaffoldState: ScaffoldState
) {
    when (getHomeScreenType(uiState)) {
        HomeScreenType.Main -> {
            HomeScreen(
                uiState = uiState,
                onClickRoutineContent = onClickRoutineContent,
                onClickSaladHistoryContent = {

                },
                onClickGreetingContent = onClickGreetingContent,
                onClickGreetingEdit = onClickGreetingEdit
            )
        }
        HomeScreenType.Loading -> {
            HomeScreen(
                uiState = uiState,
                onClickRoutineContent = onClickRoutineContent,
                onClickSaladHistoryContent = {},
                onClickGreetingContent = onClickGreetingContent,
                onClickGreetingEdit = onClickGreetingEdit
            )
        }
        HomeScreenType.EditPage -> {
            if (uiState is HomeUiState.EditScreenUiState) {
                RoutineEditScreen(
                    title = "What are you goals?",
                    subtitle = "Select all that apply",
                    uiState = editUiState,
                    onClickEditDoneButton = onClickEditDoneButton
                )
            }
        }
    }
}

private enum class HomeScreenType {
    Main,
    EditPage,
    Loading
}

private fun getHomeScreenType(uiState: HomeUiState): HomeScreenType {
    return when (uiState) {
        is HomeUiState.HasAssets -> {
            HomeScreenType.Main
        }
        is HomeUiState.NoAssets -> {
            HomeScreenType.Loading
        }
        is HomeUiState.EditScreenUiState -> {
            HomeScreenType.EditPage
        }
    }
}