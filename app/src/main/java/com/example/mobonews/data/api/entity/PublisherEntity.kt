package com.example.mobonews.data.api.entity


import com.example.mobonews.domain.model.Publisher
import com.google.gson.annotations.SerializedName

data class PublisherEntity(
    @SerializedName("category")
    val category: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("title")
    val title: String,
)

fun PublisherEntity.mapToDomainModel(): Publisher {
    return Publisher(
        category = category,
        id = id,
        imageUrl = imageUrl,
        title = title,
    )
}