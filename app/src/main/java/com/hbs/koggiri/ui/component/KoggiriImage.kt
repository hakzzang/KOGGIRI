package com.hbs.koggiri.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hbs.koggiri.models.IconItem

@Composable
fun SmallEmojiIcon(
    iconItem: IconItem,
    containerSize: Dp,
    shape: RoundedCornerShape = RoundedCornerShape(12.dp),
    elevation: Dp = 0.dp,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.size(containerSize),
        shape = shape,
        elevation = elevation,
        backgroundColor = iconItem.backgroundColor
    ) {
        Text(
            modifier = Modifier.fillMaxSize(),
            text = iconItem.icon.toString(),
            fontSize = containerSize.value.sp,
        )
    }
}