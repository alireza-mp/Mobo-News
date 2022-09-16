package com.example.mobonews.domain.model

data class HotNews(
    val category: String,
    val id: Int,
    val newsId: Int,
    val imageUrl: String,
    val publisher: String,
    val publisherImageUrl: String,
    val recommended: String,
    val time: String,
    val title: String,
)