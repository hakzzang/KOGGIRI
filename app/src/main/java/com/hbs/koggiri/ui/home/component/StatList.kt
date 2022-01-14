package com.hbs.koggiri.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.ui.component.LayoutGravityEndText
import com.hbs.koggiri.ui.component.OneItemBody
import com.hbs.koggiri.ui.component.OneItemTitle

@Composable
fun StatItemList(stats: List<String>, onClickStatContent: (String) -> Unit) {
    stats.forEach {
        StatItem(it, onClickStatContent)
    }
}

@Composable
fun StatItem(
    stat: String,
    onClickStatContent: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                onClick = { onClickStatContent(stat) },
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple()
            )
            .padding(start = STAT_ITEM_SIDE_PADDING, end = STAT_ITEM_SIDE_PADDING)
            .height(STAT_ITEM_CONTAINER_HEIGHT),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(
                    start = 8.dp,
                    top = 8.dp,
                    end = 8.dp,
                    bottom = 8.dp
                )
        ) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Check"
            )
        }
        Column(
            modifier = Modifier
                .padding(
                    start = STAT_ITEM_SIDE_PADDING,
                    end = STAT_ITEM_SIDE_PADDING,
                    top = STAT_ITEM_TOP_BOTTOM_PADDING,
                    bottom = STAT_ITEM_TOP_BOTTOM_PADDING
                )
                .fillMaxHeight()
                .align(Alignment.CenterVertically)
                .wrapContentWidth()
        ) {
            OneItemTitle(stat)
            OneItemBody("샐러드 먹기")
        }
        LayoutGravityEndText("100")
    }
}

private val STAT_ITEM_CONTAINER_HEIGHT = 56.dp
private val STAT_ITEM_SIDE_PADDING = 16.dp
private val STAT_ITEM_TOP_BOTTOM_PADDING = 8.dp