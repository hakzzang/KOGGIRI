package com.hbs.koggiri.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.ui.component.getCardModifier
import com.hbs.koggiri.ui.home.component.SaladHistoryContent
import com.hbs.koggiri.ui.home.component.StatsContent

@Composable
fun HomeScreenBody(
    onClickStatContent: (String) -> Unit,
    onClickSaladHistoryContent: () -> Unit
) {
    val saladHistories = listOf(
        "2022년 1월 1일",
        "2022년 1월 2일",
        "2022년 1월 3일",
        "2022년 1월 4일",
        "2022년 1월 5일",
        "2022년 1월 6일"
    )

    val stats = listOf(
        "Days Running",
        "Days Eating Salad",
        "Days Watching Calmdown Man"
    )
    val scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState)) {
        StatsContent(
            stats = stats,
            onClickStatContent = onClickStatContent,
            modifier = Modifier.getCardModifier()
        )
        SaladHistoryContent(
            saladHistories = saladHistories,
            modifier = Modifier.getCardModifier()
        )
        Spacer(Modifier.height(72.dp))
    }
}

