package com.hbs.koggiri.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*

@Composable
fun KoggiriBottomBar(
    bottomTabs: List<KoggiriScreen>,
    onClickItemCallback: (Int) -> Unit,
    currentScreen: KoggiriScreen
) {
    NavigationBar {
        bottomTabs.forEachIndexed { index, screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = null) },
                label = { Text(screen.title) },
                selected = currentScreen == KoggiriScreen.screenOf(index),
                onClick = { onClickItemCallback(index) }
            )
        }
    }
}

