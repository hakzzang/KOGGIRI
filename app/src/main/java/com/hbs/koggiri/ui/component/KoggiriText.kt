package com.hbs.koggiri.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun KoggiriLargeTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        title,
        style = MaterialTheme.typography.headlineMedium.copy(
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold
        ),
        modifier = modifier
    )
}

@Composable
fun KoggiriMediumTitle(
    title: String,
    color: Color = MaterialTheme.colorScheme.onSurface,
    modifier: Modifier = Modifier
) {
    Text(
        title,
        style = MaterialTheme.typography.titleLarge.copy(
            color = color,
            fontWeight = FontWeight.Bold
        ),
        modifier = modifier
            .wrapContentWidth()
            .height(MEDIUM_CONTAINER_HEIGHT)
            .padding(
                start = MEDIUM_CONTAINER_SIDE_PADDING,
                end = MEDIUM_CONTAINER_SIDE_PADDING
            )
    )
}

@Composable
fun MediumTitleWithIcon(title: String, onClickIcon: () -> Unit) {
    Row {
        KoggiriMediumTitle(
            title = title,
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.Start)
        )
        Icon(
            Icons.Filled.AddCircle,
            contentDescription = "추가",
            modifier = Modifier.size(32.dp)
                .clickable(
                    onClick = onClickIcon,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple()
                )
        )
        Spacer(modifier = Modifier.size(12.dp))
    }
}

@Composable
fun KoggiriSmallText(
    title: String,
    color: Color = MaterialTheme.colorScheme.onSurface,
    modifier: Modifier = Modifier
) {
    Text(
        title,
        style = MaterialTheme.typography.titleSmall.copy(
            color = color,
            fontWeight = FontWeight.Bold
        ),
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(
                start = MEDIUM_CONTAINER_SIDE_PADDING,
                end = MEDIUM_CONTAINER_SIDE_PADDING
            )
    )
}

@Composable
fun OneItemTitle(title: String) {
    Text(
        title,
        style = MaterialTheme.typography.titleMedium.copy(
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
    )
}

@Composable
fun OneItemBody(title: String) {
    Text(
        title,
        style = MaterialTheme.typography.labelMedium,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
    )
}

@Composable
fun LayoutGravityEndText(text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.End,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineSmall.copy(
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive
            )
        )
    }
}

private val ONE_ITEM_TITLE_SIDE_PADDING = 16.dp

private val MEDIUM_CONTAINER_HEIGHT = 48.dp

private val MEDIUM_CONTAINER_SIDE_PADDING = 16.dp