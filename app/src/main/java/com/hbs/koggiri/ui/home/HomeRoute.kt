package com.hbs.koggiri.ui.home

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    val uiState by homeViewModel.uiState.collectAsState()

    HomeRoute(
        uiState = uiState,
        onClickStatContent = { },
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
    onClickStatContent: (String) -> Unit,
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
                onClickStatContent = onClickStatContent,
                onClickSaladHistoryContent = {},
                onClickGreetingContent = onClickGreetingContent,
                onClickGreetingEdit = onClickGreetingEdit
            )
        }
        HomeScreenType.Loading -> {
            HomeScreen(
                uiState = uiState,
                onClickStatContent = onClickStatContent,
                onClickSaladHistoryContent = {},
                onClickGreetingContent = onClickGreetingContent,
                onClickGreetingEdit = onClickGreetingEdit
            )
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
    }
}