package com.hbs.koggiri.ui.component

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.hbs.data.routine.RoutineRepositoryImpl
import com.hbs.koggiri.KoggiriScreen
import com.hbs.koggiri.models.CalendarFactory
import com.hbs.koggiri.ui.history.CalendarScreenBody
import com.hbs.koggiri.ui.home.HomeRoute
import com.hbs.koggiri.ui.home.HomeViewModel
import com.hbs.koggiri.ui.setting.SettingScreenBody
import com.hbs.koggiri.ui.status.StatusDetailScreen

@Composable
fun KoggiriNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = KoggiriScreen.Home.title,
        modifier = Modifier
    ) {
        composable(KoggiriScreen.Home.title) {
            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeViewModel.provideFactory(RoutineRepositoryImpl())
            )
            HomeRoute(homeViewModel)
        }
        composable(KoggiriScreen.CALENDAR.title) {
            val calendarPresentations = CalendarFactory.getCalendarPresentations()
            CalendarScreenBody(calendarPresentations, { calendarPresentation ->

            }, Modifier.getCardModifier())
        }
        composable(KoggiriScreen.SETTING.title) {
            SettingScreenBody()
        }
        composable(
            route = "${KoggiriScreen.GREETING}/edit",
            arguments = listOf(),
            deepLinks = listOf(navDeepLink {
                uriPattern = "koggiri://${KoggiriScreen.GREETING}/edit"
            })
        ) { entry ->
            var isComplete by remember { mutableStateOf(false) }
            StatusDetailScreen(title = "EDIT", isComplete, {
                isComplete = it
            })
        }
        composable(
            route = "${KoggiriScreen.GREETING}/content/{day}",
            arguments = listOf(
                navArgument("day") {
                    type = NavType.StringType
                }
            ),
            deepLinks = listOf(navDeepLink {
                uriPattern = "koggiri://${KoggiriScreen.GREETING}/content/{day}"
            })
        ) { entry ->
            val day = entry.arguments?.getString("day")
            var isComplete by remember { mutableStateOf(false) }
            StatusDetailScreen(title = day ?: "", isComplete, {
                isComplete = it
            })
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