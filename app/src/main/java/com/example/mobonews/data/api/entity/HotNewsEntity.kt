package com.example.mobonews.data.api.entity


import com.example.mobonews.domain.model.HotNews
import com.google.gson.annotations.SerializedName

data class HotNewsEntity(
    @SerializedName("category")
    val category: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("publisher_image_url")
    val publisherImageUrl: String,
    @SerializedName("recommended")
    val recommended: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("title")
    val title: String,
)

 fun HotNewsEntity.mapToDomainModel(): HotNews {
    return HotNews(
        category = category,
        id = id,
        imageUrl = imageUrl,
        publisher = publisher,
        publisherImageUrl = publisherImageUrl,
        recommended = recommended,
        time = time,
        title = title,
    )
}

