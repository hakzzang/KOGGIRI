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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.hbs.koggiri.models.MediumImageCardItem

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