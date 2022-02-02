package com.hbs.koggiri.ui.home

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.hbs.koggiri.models.RoutinePresentation

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
        onClickSaladHistoryContent = {},
        onClickGreetingContent = { },
        onClickGreetingEdit = { },
        scaffoldState = scaffoldState
    )
}

@Composable
fun HomeRoute(
    uiState: HomeUiState,
    onClickSaladHistoryContent: () -> Unit,
    onClickGreetingContent: (String) -> Unit,
    onClickGreetingEdit: (String) -> Unit,
    onClickRoutineContent: (RoutinePresentation) -> Unit,
    scaffoldState: ScaffoldState
) {
    when (getHomeScreenType(uiState)) {
//        onClickSaladHistoryContent = { },
//        onClickGreetingContent = {
//            setCurrentScreen(KoggiriScreen.fromRoute(it))
//            navController.navigate(it)
//        },
//        onClickGreetingEdit = {
//            setCurrentScreen(KoggiriScreen.fromRoute(it))
//            navController.navigate(it)
//        },
//        onClickStatContent = { item ->
//            setCurrentScreen(KoggiriScreen.fromRoute(item))
//            navController.navigate("${KoggiriScreen.Home.title}/$item\"")
//        }
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
        HomeScreenType.HomeWithDetail -> {

        }
    }
}

private enum class HomeScreenType {
    Main,
    HomeWithDetail,
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
            HomeScreenType.HomeWithDetail
        }
    }
}