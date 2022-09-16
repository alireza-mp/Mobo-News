package com.example.mobonews.domain.model

// recommended news
data class FavoriteNews(
    val category: String,
    val description: String,
    val id: Int,
    val newsId: Int,
    val imageUrl: String,
    val publisher: String,
    val publisherImageUrl: String,
    val title: String,
)