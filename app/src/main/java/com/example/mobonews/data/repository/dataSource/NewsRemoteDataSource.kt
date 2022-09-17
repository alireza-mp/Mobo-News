package com.example.mobonews.data.repository.dataSource

import com.example.mobonews.data.api.entity.FavoriteNewsEntity
import com.example.mobonews.data.api.entity.HotNewsEntity
import com.example.mobonews.data.api.entity.NewsDetailEntity
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getHotNews(): Response<List<HotNewsEntity>>?
    suspend fun getFavoriteNews(): Response<List<FavoriteNewsEntity>>?
    suspend fun getNewsDetail(newsId: Int): Response<NewsDetailEntity>?

}