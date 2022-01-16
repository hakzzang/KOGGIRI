package com.hbs.koggiri.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.ui.component.KoggiriLargeTitle
import com.hbs.koggiri.ui.component.KoggiriMediumTitle
import com.hbs.koggiri.ui.theme.PointColor

@Composable
fun GreetingContent(
    onClickGreetingContent: (String) -> Unit,
    onClickEdit: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column (modifier = modifier) {
        Row {
            KoggiriMediumTitle(
                title = "Today Calorie Asset",
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            Icon(
                Icons.Filled.Edit,
                contentDescription = "편집",
                modifier = Modifier
                    .size(32.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(
                            radius = 16.dp
                        ),
                        onClick = { onClickEdit() }
                    )
            )
            Spacer(modifier = Modifier.size(12.dp))
        }
        Row {
            Box(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(PointColor)
                    .padding(
                        start = 8.dp,
                        top = 8.dp,
                        end = 8.dp,
                        bottom = 8.dp
                    )
            ) {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Check",
                    tint = Color.White
                )
            }
            KoggiriLargeTitle(
                title = "Saved 2400cal \uD83E\uDD51",
                modifier = Modifier.wrapContentWidth().wrapContentHeight()
            )
        }
    }
}

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