package com.hbs.koggiri.ui

import androidx.compose.runtime.Composable
import com.hbs.koggiri.ui.component.KoggiriScaffold
import com.hbs.koggiri.ui.theme.KOGGIRITheme

@Composable
fun KoggiriApp() {
    KOGGIRITheme {
        KoggiriScaffold()
    }
}