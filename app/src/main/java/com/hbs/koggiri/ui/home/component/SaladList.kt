package com.hbs.koggiri.ui.home.component

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.hbs.koggiri.R
import com.hbs.koggiri.ui.component.MediumCard

@Composable
fun CardList(saladHistories: List<String>) {
    LazyRow {
        items(saladHistories) { date ->
            MediumCard("salad", date, painterResource(id = R.drawable.salad01))
        }
    }
}
