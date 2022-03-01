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

    HomeRoute(
        uiState = uiState,
        onClickRoutineContent = { routine ->
            homeViewModel.clickRoutineContent(routine)
        },
        onClickGreetingContent = { },
        onClickGreetingEdit = { },
        onCompleteHomeDetail = { },
        scaffoldState = scaffoldState
    )
}

@Composable
fun HomeRoute(
    uiState: HomeUiState,
    onClickGreetingContent: (String) -> Unit,
    onClickGreetingEdit: (String) -> Unit,
    onClickRoutineContent: (RoutinePresentation) -> Unit,
    onCompleteHomeDetail: (Boolean) -> Unit,
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
            if (uiState is HomeUiState.HasDetailAssets) {
                RoutineEditScreen(
                    title = "What are you goals?",
                    subtitle = "Select all that apply",
                    uiState = uiState
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
        is HomeUiState.HasDetailAssets -> {
            HomeScreenType.EditPage
        }
    }
}