package com.hbs.koggiri.ui.component

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.hbs.koggiri.ui.history.HistoryScreenBody
import com.hbs.koggiri.ui.home.HomeScreenBody
import com.hbs.koggiri.ui.setting.SettingScreenBody
import com.hbs.koggiri.ui.status.StatusDetailScreen

@Composable
fun KoggiriNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = KoggiriScreen.Home.title,
        modifier = modifier
    ) {
        composable(KoggiriScreen.Home.title) {
            HomeScreenBody(
                onClickStatContent = { item -> navController.navigate("${KoggiriScreen.Home.title}/$item\"") },
                onClickSaladHistoryContent = {})
        }
        composable(KoggiriScreen.HISTORY.title) {
            HistoryScreenBody()
        }
        composable(KoggiriScreen.SETTING.title) {
            SettingScreenBody()
        }

        composable(
            route = "${KoggiriScreen.Home}/{status}",
            arguments = listOf(
                navArgument("status") {
                    type = NavType.StringType
                }
            ),
            deepLinks = listOf(navDeepLink {
                uriPattern = "koggiri://${KoggiriScreen.Home}/{status}"
            })
        ) { entry ->
            val status = entry.arguments?.getString("status")
            var isComplete by remember { mutableStateOf(false) }
            StatusDetailScreen(title = status ?: "", isComplete, {
                isComplete = it
            })
        }
    }
}