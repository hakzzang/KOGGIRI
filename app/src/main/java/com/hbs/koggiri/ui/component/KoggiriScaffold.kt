package com.hbs.koggiri.ui.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KoggiriScaffold() {
    val bottomTabs = KoggiriScreen.getBottomTabs()
    val navController = rememberNavController()
    var clickedItem by remember { mutableStateOf(INITIALIZE_TAB_POSITION) }
    var stackSize by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            KoggiriTopBar(
                nodeSize = stackSize,
                onClickNavigateIcon = {
                    stackSize = navController.popBackStackAndReturnBackStack(it)
                })
        },
        bottomBar = {
            KoggiriBottomBar(
                bottomTabs = bottomTabs,
                onClickItemCallback = { index ->
                    stackSize =
                        navController.navigateAndReturnBackStack(KoggiriScreen.fromRoute(index))
                    clickedItem = index
                },
                clickedItem = clickedItem
            )
        }
    ) {
        KoggiriNavHost(
            navController = navController,
            onClickSaladHistoryContent = { },
            onClickGreetingContent = { stackSize = navController.navigateAndReturnBackStack(it) },
            onClickGreetingEdit = { stackSize = navController.navigateAndReturnBackStack(it) },
            onClickStatContent = { item ->
                stackSize =
                    navController.navigateAndReturnBackStack("${KoggiriScreen.Home.title}/$item\"")
            },
            modifier = Modifier
        )
    }
}

fun NavHostController.navigateAndReturnBackStack(route: String): Int {
    navigate(route)
    return runCatching { graph.map { getBackStackEntry(graph.id) } }.getOrNull()?.size ?: 0
}

fun NavHostController.popBackStackAndReturnBackStack(action: String): Int {
    if (action == "Menu") {

    } else if (action == "Back") {
        popBackStack()
    }
    return 0
}


private const val INITIALIZE_TAB_POSITION = 0