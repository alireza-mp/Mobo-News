package com.example.mobonews.domain.model


data class NewsDetail(
    val body: String,
    val categoryList: List<Category>,
    val description: String,
    val id: Int,
    val imageUrl: String,
    val publisher: String,
    val publisherImageUrl: String,
    val recommended: String,
    val time: String,
    val title: String,
)