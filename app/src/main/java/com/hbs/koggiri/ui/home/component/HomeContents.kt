package com.hbs.koggiri.ui.home.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.ui.component.KoggiriMediumTitle

@Composable
fun StatsContent(
    stats: List<String>,
    onClickStatContent: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column (modifier = modifier) {
        Row {
            KoggiriMediumTitle(
                title = "Your stats",
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            Icon(
                Icons.Filled.AddCircle,
                contentDescription = "추가",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.size(12.dp))
        }
        StatItemList(stats = stats, onClickStatContent = onClickStatContent)
    }
}

@Composable
fun SaladHistoryContent(saladHistories: List<String>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row {
            KoggiriMediumTitle(
                title = "Salad History",
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            Icon(
                Icons.Filled.AddCircle,
                contentDescription = "추가",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.size(12.dp))
        }
        SaladCardList(saladHistories = saladHistories)
    }
}