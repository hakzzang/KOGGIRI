package com.hbs.koggiri.ui.component

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KoggiriScaffold() {
    val allScreen = KoggiriScreen.values().toList()
    val navController = rememberNavController()
    val backQueueSize = remember { navController.backQueue.size }
    var clickedItem by remember { mutableStateOf(INITIALIZE_TAB_POSITION) }
    Scaffold(
        topBar = { KoggiriTopBar(backQueueSize) },
        bottomBar = {
            KoggiriBottomBar(
                allScreen = allScreen,
                onClickItemCallback = { index ->
                    navController.navigate(KoggiriScreen.fromRoute(index))
                    clickedItem = index
                },
                clickedItem = clickedItem
            )
        }
    ) {
        KoggiriNavHost(
            navController = navController,
            modifier = Modifier
        )
    }
}

private const val INITIALIZE_TAB_POSITION = 0