package com.hbs.koggiri.ui.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KoggiriScaffold() {
    val allScreen = KoggiriScreen.values().toList()
    val navController = rememberNavController()

    Scaffold(
        topBar = { KoggiriTopBar() },
        bottomBar = { KoggiriBottomBar(allScreen = allScreen) }
    ) {
        KoggiriNavHost(
            navController = navController,
            modifier = Modifier
        )
    }
}