package com.hbs.koggiri.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.ui.home.component.SaladHistoryContent
import com.hbs.koggiri.ui.home.component.StatsContent
import com.hbs.koggiri.ui.theme.NeutralVariant95

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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NeutralVariant95)
            .verticalScroll(scrollState)
            .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 96.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 24.dp, bottom = 24.dp)
    ) {
        StatsContent(stats = stats, onClickStatContent = onClickStatContent)
        Spacer(modifier = Modifier.height(18.dp))
        SaladHistoryContent(saladHistories)
    }
}

