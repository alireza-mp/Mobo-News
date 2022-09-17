package com.example.mobonews.domain.repository

import com.example.mobonews.domain.model.NewsDetail
import com.example.mobonews.util.DataState
import kotlinx.coroutines.flow.Flow


interface NewsDetailRepository {

    // get news detail by newsId
    suspend fun getNewsDetail(newsId: Int): Flow<DataState<NewsDetail>>

}