package com.hbs.koggiri.ui.component

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.hbs.koggiri.KoggiriScreen
import com.hbs.koggiri.ui.theme.NeutralVariant95

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KoggiriTopBar(tab: KoggiriScreen, onClickNavigateIcon: (String) -> Unit) {
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val scrollBehavior = remember(decayAnimationSpec) {
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
    }
    CenterAlignedTopAppBar(
        title = { Text("KOGGIRI") },
        navigationIcon = {
            IconButton(onClick = {
                onClickNavigateIcon(if (tab.isMainTab()) "Menu" else "Back")
            }) {
                Icon(
                    imageVector = if (tab.isMainTab()) Icons.Filled.Menu else Icons.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Localized description"
                )
            }
        },
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = NeutralVariant95
        )
    )
}