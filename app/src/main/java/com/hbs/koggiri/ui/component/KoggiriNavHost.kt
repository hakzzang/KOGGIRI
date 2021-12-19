package com.hbs.koggiri.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hbs.koggiri.ui.history.HistoryScreenBody
import com.hbs.koggiri.ui.home.HomeScreenBody
import com.hbs.koggiri.ui.setting.SettingScreenBody

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
            HomeScreenBody()
        }
        composable(KoggiriScreen.HISTORY.title) {
            HistoryScreenBody()
        }
        composable(KoggiriScreen.SETTING.title) {
            SettingScreenBody()
        }
    }
}