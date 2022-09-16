package com.example.mobonews.data.repository

import com.example.mobonews.data.api.entity.mapToDomainModel
import com.example.mobonews.data.repository.dataSource.NewsRemoteDataSource
import com.example.mobonews.domain.model.FavoriteNews
import com.example.mobonews.domain.model.HotNews
import com.example.mobonews.domain.repository.NewsRepository
import com.example.mobonews.util.DataState
import javax.inject.Inject

class NewsRepositoryImpl
@Inject
constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
) : NewsRepository {

    override suspend fun getHotNews(): DataState<List<HotNews>> {
        val response = newsRemoteDataSource.getHotNews()
        response?.let {
            if (response.isSuccessful) {
                response.body()?.let { list ->
                    return DataState.Success(
                        list.map { it.mapToDomainModel() }
                    )
                }
            }
        }
        return DataState.Error
    }

    override suspend fun getFavoriteNews(): DataState<List<FavoriteNews>> {
        val response = newsRemoteDataSource.getFavoriteNews()
        response?.let {
            if (response.isSuccessful) {
                response.body()?.let { list ->
                    return DataState.Success(
                        list.map { it.mapToDomainModel() }
                    )
                }
            }
        }
        return DataState.Error
    }


}