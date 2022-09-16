package com.example.mobonews.domain.model

data class Recommended(
    val HotNewsList: List<HotNews>,
    val FavoriteNewsList: List<FavoriteNews>,
)