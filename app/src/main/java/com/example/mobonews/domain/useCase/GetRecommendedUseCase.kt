package com.example.mobonews.domain.useCase

import com.example.mobonews.domain.model.Recommended
import com.example.mobonews.domain.repository.NewsRepository
import com.example.mobonews.util.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch


class GetRecommendedUseCase(
    private val repository: NewsRepository,
) {

    suspend operator fun invoke() = initialData()

    // combine hot news and favorite news lists to recommended model
    private suspend fun initialData(): Flow<DataState<Recommended>> = callbackFlow {
        launch(Dispatchers.IO) {
            trySend(DataState.Loading)
            val hotNewsData = async { repository.getHotNews() }
            val favoriteData = async { repository.getFavoriteNews() }
            val hotNewsResult = hotNewsData.await()
            val favoriteResult = favoriteData.await()
            when {
                hotNewsResult is DataState.Success && favoriteResult is DataState.Success -> {
                    trySend(DataState.Success(
                        Recommended(
                            HotNewsList = hotNewsResult.data,
                            FavoriteNewsList = favoriteResult.data,
                        )
                    ))
                }
                hotNewsResult is DataState.Error || favoriteResult is DataState.Error -> {
                    trySend(DataState.Error)
                }
            }
        }
        awaitClose {
            channel.close()
        }
    }
}


