@file:OptIn(ExperimentalFoundationApi::class)

package com.hbs.koggiri.ui.home.component

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.KoggiriScreen
import com.hbs.koggiri.R
import com.hbs.koggiri.models.RoutinePresentation
import com.hbs.koggiri.models.SelectionRoutinePresentation
import com.hbs.koggiri.ui.component.*
import com.hbs.koggiri.ui.theme.KOGGIRITheme
import com.hbs.koggiri.ui.theme.PointBlueColor

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewSelectionRoutineItem() {
    KOGGIRITheme {
        Surface {
            SelectionRoutineItem(
                selectedPosition = 0,
                position = 0,
                resource = painterResource(R.drawable.salad01),
                title = "Title"
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewSelectionRoutineList() {
    KOGGIRITheme {
        Surface {
            SelectionRoutineList(
                listOf(
                    SelectionRoutinePresentation("Test", R.drawable.salad01),
                    SelectionRoutinePresentation("Test1", R.drawable.salad01),
                    SelectionRoutinePresentation("Test2", R.drawable.salad01),
                    SelectionRoutinePresentation("Test3", R.drawable.salad01)
                )
            )
        }
    }
}

@Composable
fun RoutineItemList(
    routine: List<RoutinePresentation>,
    onClickRoutineContent: (RoutinePresentation) -> Unit
) {
    routine.forEach {
        RoutineItem(it, onClickRoutineContent, {})
    }
}

@Composable
fun RoutineItem(
    routine: RoutinePresentation,
    onClickRoutineContent: (RoutinePresentation) -> Unit,
    onClickAddRoutine: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                onClick = { onClickRoutineContent(routine) },
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
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Check",
                modifier = Modifier.clickable(
                    onClick = { onClickAddRoutine(KoggiriScreen.GREETING + "/content/ALL") },
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple()
                )
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
            OneItemTitle(routine.title)
            OneItemBody(routine.memo)
        }
        LayoutGravityEndText(routine.completedCount.toString())
    }
}

@Composable
fun SelectionRoutineList(
    selectionRoutines: List<SelectionRoutinePresentation> = listOf(),
    modifier: Modifier = Modifier,
) {
    var selectionPosition by remember { mutableStateOf(0) }
    LazyVerticalGrid(
        cells = GridCells.Fixed(GRID_CELL_COUNT),
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 4.dp)
    ) {
        items(selectionRoutines.size) { index ->
            val (title, resource) = selectionRoutines[index]
            SelectionRoutineItem(
                selectedPosition = selectionPosition,
                position = index,
                resource = painterResource(resource),
                title = title,
                onClick = { position -> selectionPosition = position}
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectionRoutineItem(
    selectedPosition: Int = 0,
    position: Int = 0,
    resource: Painter,
    title: String = "Test",
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(172.dp)
        .padding(horizontal = 4.dp, vertical = 4.dp),
    roundedCornerShape: RoundedCornerShape = RoundedCornerShape(12.dp),
    elevation: Dp = 2.dp,
    cardColor: Color = Color.White,
    onClick: ((Int) -> Unit)? = null
) {
    val selectedColor = if (position == selectedPosition) {
        PointBlueColor
    } else {
        Color.Black
    }
    Card(
        shape = roundedCornerShape,
        modifier = modifier,
        elevation = elevation,
        backgroundColor = cardColor,
        border = BorderStroke(2.dp, selectedColor),
        onClick = { onClick?.invoke(position) }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp),
                    painter = resource,
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = selectedColor
                    )
                )
            }
        }
    }
}

private val STAT_ITEM_CONTAINER_HEIGHT = 56.dp
private val STAT_ITEM_SIDE_PADDING = 16.dp
private val STAT_ITEM_TOP_BOTTOM_PADDING = 8.dp
private const val GRID_CELL_COUNT = 3