package com.example.mobonews.data.repository.dataSourceImpl

import com.example.mobonews.data.api.entity.mapToDomainModel
import com.example.mobonews.data.repository.dataSource.NewsRemoteDataSource
import com.example.mobonews.domain.model.NewsDetail
import com.example.mobonews.domain.repository.NewsDetailRepository
import com.example.mobonews.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class NewsDetailRepositoryImpl
@Inject
constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
) : NewsDetailRepository {

    override suspend fun getNewsDetail(newsId: Int): Flow<DataState<NewsDetail>> = flow {
        emit(DataState.Loading)
        val result = newsRemoteDataSource.getNewsDetail(newsId)
        result ?: emit(DataState.Error)
        result?.let {
            if (result.isSuccessful && result.body() != null) {
                emit(DataState.Success(result.body()!!.mapToDomainModel()))
            } else emit(DataState.Error)
        }
    }
}