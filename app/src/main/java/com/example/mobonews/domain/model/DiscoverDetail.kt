package com.example.mobonews.domain.model

data class DiscoverDetail(
    val bannerUrls: List<String>,
    val publishers: List<Publisher>,
    val subtitle: String,
    val newsList: List<HotNews>,
)