package com.hbs.koggiri.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.R

@Composable
fun WeightCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(216.dp)
            .padding(start = 16.dp, end = 16.dp, bottom = 24.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        Text(
            text = "2021년 12월 25일",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 24.dp),
            style = MaterialTheme.typography.displaySmall,
        )
    }
}

@Composable
fun CardList(saladHistories: List<String>) {
    LazyRow {
        items(saladHistories) { date ->
            MediumCard("salad", date, painterResource(id = R.drawable.salad01))
        }
    }
}

@Composable
fun MediumCard(title: String, dateText: String, resource: Painter) {
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
            Image(
                painter = resource,
                contentDescription = "Salad",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                alignment = Alignment.Center
            )
            Text(
                dateText,
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
                Text(title)
            }
        }
    }
}