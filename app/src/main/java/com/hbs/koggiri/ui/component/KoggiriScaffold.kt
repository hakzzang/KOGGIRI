package com.hbs.koggiri.ui.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KoggiriScaffold() {
    val mainTabs = KoggiriScreen.mainTabs
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val (currentScreen, setCurrentScreen) = remember { mutableStateOf(
        KoggiriScreen.fromRoute(navBackStackEntry?.destination?.route?:KoggiriScreen.Home.title)
    ) }

    Scaffold(
        topBar = {
            KoggiriTopBar(
                currentScreen,
                onClickNavigateIcon = {
                    if (!currentScreen.isMainTab()) {
                        navController.popBackStack()
                        val toIndex = navController.backQueue.indexOf(navController.currentBackStackEntry)
                        val route = navController.backQueue[toIndex].destination.route?:""
                        setCurrentScreen(KoggiriScreen.fromRoute(route))
                    }
                })
        },
        bottomBar = {
            KoggiriBottomBar(
                bottomTabs = mainTabs,
                onClickItemCallback = { index ->
                    setCurrentScreen(KoggiriScreen.screenOf(index))
                    navController.navigate(currentScreen.title)
                },
                currentScreen = currentScreen
            )
        }
    ) {
        KoggiriNavHost(
            navController = navController,
            onClickSaladHistoryContent = { },
            onClickGreetingContent = {
                setCurrentScreen(KoggiriScreen.fromRoute(it))
                navController.navigate(it)
            },
            onClickGreetingEdit = {
                setCurrentScreen(KoggiriScreen.fromRoute(it))
                navController.navigate(it)
            },
            onClickStatContent = { item ->
                setCurrentScreen(KoggiriScreen.fromRoute(item))
                navController.navigate("${KoggiriScreen.Home.title}/$item\"")
            },
            modifier = Modifier
        )
    }
}


private const val INITIALIZE_TAB_POSITION = 0