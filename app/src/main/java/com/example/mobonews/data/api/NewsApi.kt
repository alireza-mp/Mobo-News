package com.example.mobonews.data.api

import com.example.mobonews.data.api.entity.HotNewsEntity
import com.example.mobonews.data.api.entity.FavoriteNewsEntity
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {

    @GET("recommended_news.php")
    suspend fun getFavoriteNews(): Response<List<FavoriteNewsEntity>>

    @GET("hot_news.php")
    suspend fun getHotNews(): Response<List<HotNewsEntity>>


}