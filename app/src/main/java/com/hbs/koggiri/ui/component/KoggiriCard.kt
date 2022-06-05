package com.hbs.koggiri.ui.component

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.hbs.koggiri.models.HorizontalTimerItem
import com.hbs.koggiri.models.MediumImageCardItem
import com.hbs.koggiri.ui.theme.NeutralVariant90

@Composable
fun MediumCard(item: MediumImageCardItem) {
    Card(
        modifier = Modifier
            .width(212.dp)
            .wrapContentHeight()
            .padding(start = 16.dp, end = 12.dp, top = 0.dp, bottom = 0.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        Column {
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data(item.imageRes)
                .crossfade(true)
                .diskCachePolicy(CachePolicy.ENABLED)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .build(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                contentScale = ContentScale.Crop,
                onError = {
                    Log.d("onError", it.result.throwable.toString())
                })
            Text(
                item.tagText,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            )
            TextButton(
                onClick = { },
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 4.dp),
                contentPadding = PaddingValues(
                    start = 8.dp,
                    top = 0.dp,
                    end = 8.dp,
                    bottom = 0.dp
                )
            ) {
                // Inner content including an icon and a text label
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(12.dp)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(item.title)
            }
        }
    }
}

@Composable
fun HorizontalTimerView(
    item: HorizontalTimerItem,
    modifier: Modifier = Modifier,
    backgroundColor: Color = NeutralVariant90,
    shape: RoundedCornerShape = RoundedCornerShape(12.dp),
    elevationDp: Dp = 0.dp,
    iconSize: Dp = 48.dp
) {
    Card(
        modifier = modifier,
        shape = shape,
        elevation = elevationDp,
        backgroundColor = backgroundColor
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (icon, title) = createRefs()
            SmallEmojiIcon(
                iconItem = item.iconItem,
                containerSize = iconSize,
                modifier = Modifier.constrainAs(icon) {
                    top.linkTo(parent.top, 4.dp)
                    start.linkTo(parent.start, 4.dp)
                    bottom.linkTo(parent.bottom, 4.dp)
                }
            )
            Column(modifier = Modifier.constrainAs(title) {
                start.linkTo(icon.end, 8.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }) {
                OneItemTitle(item.title)
                OneItemBody(item.content)
            }
        }
    }
}