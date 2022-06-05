package com.hbs.koggiri.models

import androidx.compose.ui.graphics.Color

data class LargeImageCardItem(
    val title: String,
    val tagText: String,
    val imageRes: String
)

data class MediumImageCardItem(
    val title: String,
    val tagText: String,
    val imageRes: Any
)

data class HorizontalTimerItem(
    val title: String,
    val content: String,
    val endTime: String,
    val iconItem: IconItem,
)

data class IconItem(
    val icon: Any,
    val backgroundColor: Color
)