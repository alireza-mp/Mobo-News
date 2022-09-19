package com.example.mobonews.data.api.entity


import com.example.mobonews.domain.model.DiscoverDetail
import com.google.gson.annotations.SerializedName

data class DiscoverDetailEntity(
    @SerializedName("banner_urls")
    val bannerUrls: List<String>,
    @SerializedName("publishers")
    val publishers: List<PublisherEntity>,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("list_news")
    val newsList: List<HotNewsEntity>,
)

fun DiscoverDetailEntity.mapToDomainModel(): DiscoverDetail {
    return DiscoverDetail(
        bannerUrls = bannerUrls,
        publishers = publishers.map { it.mapToDomainModel() },
        subtitle = subtitle,
        newsList = newsList.map { it.mapToDomainModel() }
    )
}