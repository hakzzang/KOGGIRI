package com.hbs.koggiri.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*

@Composable
fun KoggiriBottomBar(
    allScreen: List<KoggiriScreen>
) {
    var selectedItem by remember { mutableStateOf(INITIALIZE_TAB_POSITION) }
    NavigationBar {
        allScreen.forEachIndexed { index, screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = null) },
                label = { Text(screen.title) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

private const val INITIALIZE_TAB_POSITION = 0