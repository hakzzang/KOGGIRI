package com.hbs.koggiri.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import com.hbs.koggiri.KoggiriScreen
import com.hbs.koggiri.models.HorizontalTimerItem
import com.hbs.koggiri.models.IconItem
import com.hbs.koggiri.models.RoutinePresentation
import com.hbs.koggiri.ui.component.*
import com.hbs.koggiri.ui.home.component.CardList
import com.hbs.koggiri.ui.home.component.RoutineItemList
import com.hbs.koggiri.ui.home.state.HomeUiState
import com.hbs.koggiri.ui.theme.NeutralVariant90
import com.hbs.koggiri.ui.theme.PointRedColor

@Composable
fun GreetingContent(
    title: String,
    onClickGreetingContent: (String) -> Unit,
    onClickGreetingEdit: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row {
            KoggiriMediumTitle(
                title = title,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = { onClickGreetingContent(KoggiriScreen.GREETING + "/content/ALL") },
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple()
                )
        ) {
            Box(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(PointRedColor)
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
            Column {
                OneItemTitle("Total Calorie Card")
                OneItemBody("72,400 calorie")
            }
        }
        Spacer(modifier = Modifier.size(24.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = { onClickGreetingContent(KoggiriScreen.GREETING + "/content/TODAY") },
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple()
                )
        ) {
            Box(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(PointRedColor.copy(alpha = 0.8f))
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
            Column {
                OneItemTitle("Today Calorie Card")
                OneItemBody("2,400 calorie")
            }
        }
    }
}

@Composable
fun RoutineContent(
    title: String,
    uiState: HomeUiState,
    onClickRoutineContent: (RoutinePresentation) -> Unit,
    modifier: Modifier = Modifier
) {
    if (uiState is HomeUiState.NoAssets) {
        return
    }
    val assets = uiState as HomeUiState.HasAssets
    Column(modifier = modifier) {
        MediumTitleWithIcon(title = title, onClickIcon = { })
        RoutineItemList(routine = assets.routines, onClickRoutineContent = onClickRoutineContent)
    }
}

@Composable
fun RoutineTimer(
    title: String,
    uiState: HomeUiState,
    modifier: Modifier = Modifier
) {
    if (uiState is HomeUiState.NoAssets) {
        return
    }
    val assets = uiState as HomeUiState.HasAssets
    Column(modifier = modifier) {
        MediumTitleWithIcon(title = title, onClickIcon = { })
        HorizontalTimerView(
            item = HorizontalTimerItem(
                """고구마 먹기""",
                """3시간 남음""",
                "2022년6월5일22:00",
                IconItem("""🍠""", Color(0xFFFB6A02))
            ),
            modifier = Modifier
                .padding(start = 16.dp, end = 12.dp, top = 0.dp, bottom = 0.dp)
        )
    }
}

@Composable
fun<T> HistoryList(title:String, datas: List<T>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        MediumTitleWithIcon(title = title, onClickIcon = { })
        CardList(datas = datas)
    }
}