package com.hbs.koggiri.ui.home.component

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.hbs.koggiri.R
import com.hbs.koggiri.models.MediumImageCardItem
import com.hbs.koggiri.ui.component.MediumCard

@Composable
fun<T> CardList(datas: List<T>) {
    LazyRow {
        items(datas) { data ->
            val cardItem = branchItemToPresentation(data)
            if (cardItem != null) {
                MediumCard(cardItem)
            }
        }
    }
}

private fun<T> branchItemToPresentation(data:T) : MediumImageCardItem? {
    if (data is String) {
        return MediumImageCardItem(title = data, tagText = "salad", R.drawable.salad01)
    }
    return null
}