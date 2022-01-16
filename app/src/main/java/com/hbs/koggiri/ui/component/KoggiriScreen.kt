package com.hbs.koggiri.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class KoggiriScreen(
    val title: String,
    val icon: ImageVector
) {
    Home("HOME", Icons.Filled.Home),
    GREETING("GREETING", Icons.Filled.Home),
    HISTORY("HISTORY", Icons.Filled.List),
    SETTING("SETTING", Icons.Filled.Settings),
    EMPTY("EMPTY", Icons.Filled.Home);

    operator fun plus(append: String): String {
        return title + append
    }

    companion object {
        fun getBottomTabs(): List<KoggiriScreen> {
            return listOf(Home, HISTORY, SETTING)
        }

        fun fromRoute(index: Int): String {
            when (index) {
                0 -> return Home.title
                1 -> return HISTORY.title
                2 -> return SETTING.title
            }
            return Home.title
        }

        fun fromRoute(title: String): KoggiriScreen {
            return when (title) {
                Home.title -> return Home
                HISTORY.title -> return HISTORY
                SETTING.title -> return SETTING
                else -> return EMPTY
            }
        }
    }
}