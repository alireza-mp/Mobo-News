package com.example.mobonews.data.api.entity


import com.example.mobonews.domain.model.Category
import com.google.gson.annotations.SerializedName

data class CategoryEntity(
    @SerializedName("title")
    val title: String,
)

fun CategoryEntity.mapToDomainModel(): Category {
    return Category(
        title = this.title
    )
}