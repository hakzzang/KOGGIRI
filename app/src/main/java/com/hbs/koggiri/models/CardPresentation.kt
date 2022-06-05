package com.hbs.koggiri.models

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