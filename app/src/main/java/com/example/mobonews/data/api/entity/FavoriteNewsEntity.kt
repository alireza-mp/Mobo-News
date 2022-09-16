package com.example.mobonews.data.api.entity


import com.example.mobonews.domain.model.FavoriteNews
import com.google.gson.annotations.SerializedName

// recommended news entity
data class FavoriteNewsEntity(
    @SerializedName("category")
    val categoryName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("publisher_image_url")
    val publisherImageUrl: String,
    @SerializedName("title")
    val title: String,
)

fun FavoriteNewsEntity.mapToDomainModel(): FavoriteNews {
    return FavoriteNews(
        category = categoryName,
        description = description,
        id = id,
        imageUrl = imageUrl,
        publisher = publisher,
        publisherImageUrl = publisherImageUrl,
        title = title
    )
}

