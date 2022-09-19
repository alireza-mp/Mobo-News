package com.example.mobonews.data.repository.dataSource

import com.example.mobonews.data.api.entity.DiscoverDetailEntity
import retrofit2.Response

interface DiscoverRemoteDataSource {

    suspend fun getDiscoverDetails(): Response<DiscoverDetailEntity>?

}