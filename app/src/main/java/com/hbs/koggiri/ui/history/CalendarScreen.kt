package com.hbs.koggiri.ui.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.ui.component.getCardModifier
import com.hbs.koggiri.ui.home.component.GalleryHistoryList
import com.hbs.koggiri.ui.home.component.GreetingContent
import com.hbs.koggiri.ui.home.component.SaladHistoryList
import com.hbs.koggiri.ui.home.component.StatsContent

@Composable
fun CalendarScreenBody() {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
    Column(Modifier.verticalScroll(scrollState)) {
//        GreetingContent(
//            onClickGreetingContent = onClickGreetingContent,
//            onClickGreetingEdit = onClickGreetingEdit,
//            modifier = Modifier.getCardModifier()
//        )
        Spacer(Modifier.height(72.dp))
    }
}