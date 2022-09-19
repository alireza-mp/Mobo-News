package com.example.mobonews.data.repository

import com.example.mobonews.data.api.entity.mapToDomainModel
import com.example.mobonews.data.repository.dataSource.DiscoverRemoteDataSource
import com.example.mobonews.domain.model.DiscoverDetail
import com.example.mobonews.domain.repository.DiscoverRepository
import com.example.mobonews.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DiscoverRepositoryImpl
@Inject
constructor(
    private val discoverRemoteDataSource: DiscoverRemoteDataSource,
) : DiscoverRepository {

    override suspend fun getDiscoverDetail(): Flow<DataState<DiscoverDetail>> =
        flow {
            emit(DataState.Loading)
            delay(300)
            val result = discoverRemoteDataSource.getDiscoverDetails()
            result ?: emit(DataState.Error)
            result?.let {
                if (result.isSuccessful && result.body() != null) {
                    emit(DataState.Success(result.body()!!.mapToDomainModel()))
                } else emit(DataState.Error)
            }
        }
}