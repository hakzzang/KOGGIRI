package com.hbs.koggiri.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class KoggiriScreen(
    val title:String,
    val icon: ImageVector
    ) {
    Home("HOME", Icons.Filled.Home),
    HISTORY("HISTORY", Icons.Filled.List),
    SETTING("SETTING", Icons.Filled.Settings);

    companion object {
        fun fromRoute(route:String?): KoggiriScreen {
            when(route) {
                "HOME" -> return Home
                "HISTORY" -> return HISTORY
                "SETTING" -> return SETTING
            }
            return Home
        }
    }
}