package com.example.mobonews.data.repository.dataSourceImpl

import com.example.mobonews.data.api.DiscoverApi
import com.example.mobonews.data.api.entity.DiscoverDetailEntity
import com.example.mobonews.data.repository.dataSource.DiscoverRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class DiscoverRemoteDataSourceImpl
@Inject
constructor(
    private val discoverApi: DiscoverApi,
) : DiscoverRemoteDataSource {

    override suspend fun getDiscoverDetails(): Response<DiscoverDetailEntity>? {
        return try {
            discoverApi.getDiscoverDetail()
        } catch (e: Exception) {
            null
        }
    }

}