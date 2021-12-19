package com.hbs.koggiri.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.ui.component.KoggiriMediumTitle
import com.hbs.koggiri.ui.home.component.SaladCardList
import com.hbs.koggiri.ui.home.component.WeightCard
import com.hbs.koggiri.ui.theme.NeutralVariant95

@Composable
fun HomeScreenBody() {
    val saladHistories = listOf(
        "2022년 1월 1일",
        "2022년 1월 2일",
        "2022년 1월 3일",
        "2022년 1월 4일",
        "2022년 1월 5일",
        "2022년 1월 6일"
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
        KoggiriMediumTitle("Your stats")
        WeightCard()

        KoggiriMediumTitle("Salad History")
        SaladCardList(saladHistories = saladHistories)
    }
}

