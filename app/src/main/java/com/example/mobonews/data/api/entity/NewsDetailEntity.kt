package com.example.mobonews.data.api.entity


import com.example.mobonews.domain.model.NewsDetail
import com.google.gson.annotations.SerializedName

data class NewsDetailEntity(
    @SerializedName("body")
    val body: String,
    @SerializedName("category_list")
    val categoryList: List<CategoryEntity>,
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
    @SerializedName("recommended")
    val recommended: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("title")
    val title: String,
)

fun NewsDetailEntity.mapToDomainModel(): NewsDetail {
    return NewsDetail(
        id = id,
        body = body,
        categoryList = categoryList.map { it.mapToDomainModel() },
        description = description,
        imageUrl = imageUrl,
        publisher = publisher,
        publisherImageUrl = publisherImageUrl,
        recommended = recommended,
        time = time,
        title = title,
    )
}
