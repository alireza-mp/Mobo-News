package com.example.mobonews.domain.repository

import com.example.mobonews.domain.model.DiscoverDetail
import com.example.mobonews.util.DataState
import kotlinx.coroutines.flow.Flow


interface DiscoverRepository {

    suspend fun getDiscoverDetail(): Flow<DataState<DiscoverDetail>>

}