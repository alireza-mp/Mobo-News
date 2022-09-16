package com.example.mobonews.data.repository.dataSourceImpl

import com.example.mobonews.data.api.NewsApi
import com.example.mobonews.data.api.entity.FavoriteNewsEntity
import com.example.mobonews.data.api.entity.HotNewsEntity
import com.example.mobonews.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class NewsRemoteDataSourceImpl
@Inject
constructor(
    private val newsApi: NewsApi,
) : NewsRemoteDataSource {
    override suspend fun getHotNews(): Response<List<HotNewsEntity>>? {
        return try {
            newsApi.getHotNews()
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getFavoriteNews(): Response<List<FavoriteNewsEntity>>? {
        return try {
            newsApi.getFavoriteNews()
        } catch (e: Exception) {
            null
        }
    }

}