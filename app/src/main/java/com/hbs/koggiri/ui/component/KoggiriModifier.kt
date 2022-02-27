package com.hbs.koggiri.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.ui.theme.NeutralVariant95

fun Modifier.getCardModifier(): Modifier = composed {
    this
        .wrapContentSize()
        .background(NeutralVariant95)
        .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(MaterialTheme.colorScheme.background)
        .padding(top = 24.dp, bottom = 24.dp)
}