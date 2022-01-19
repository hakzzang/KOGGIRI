package com.hbs.koggiri

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
    GREETING_DETAIL("GREETING_DETAIL", Icons.Filled.Home),
    GREETING_EDIT("GREETING_EDIT", Icons.Filled.Home),
    STAT_DETAIL("STAT_DETAIL", Icons.Filled.Home),
    ASSET("ASSET", Icons.Filled.List),
    SETTING("SETTING", Icons.Filled.Settings),
    EMPTY("EMPTY", Icons.Filled.Home);

    operator fun plus(append: String): String {
        return title + append
    }

    fun isMainTab(): Boolean {
        return mainTabs.contains(this)
    }

    companion object {
        val mainTabs = listOf(Home, ASSET, SETTING)

        fun screenOf(index: Int): KoggiriScreen {
            return if (mainTabs.size > index && index < 0) {
                EMPTY
            } else {
                mainTabs[index]
            }
        }

        fun fromRoute(route: String): KoggiriScreen {
            when (route) {
                Home.title -> return Home
                ASSET.title -> return ASSET
                SETTING.title -> return SETTING
            }
            return EMPTY
        }
    }
}