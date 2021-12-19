package com.hbs.koggiri.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun KoggiriMediumTitle(title: String) {
    Text(
        title,
        style = MaterialTheme.typography.titleLarge.copy(
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(MEDIUM_CONTAINER_HEIGHT)
            .padding(
                start = MEDIUM_CONTAINER_SIDE_PADDING,
                end = MEDIUM_CONTAINER_SIDE_PADDING
            )
    )
}

private val MEDIUM_CONTAINER_HEIGHT = 48.dp
private val MEDIUM_CONTAINER_SIDE_PADDING = 16.dp