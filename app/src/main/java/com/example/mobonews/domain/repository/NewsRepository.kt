package com.example.mobonews.domain.repository

import com.example.mobonews.domain.model.FavoriteNews
import com.example.mobonews.domain.model.HotNews
import com.example.mobonews.util.DataState


interface NewsRepository {

    // get hot news list
    suspend fun getHotNews(): DataState<List<HotNews>>

    //get favorite news list
    suspend fun getFavoriteNews(): DataState<List<FavoriteNews>>
}