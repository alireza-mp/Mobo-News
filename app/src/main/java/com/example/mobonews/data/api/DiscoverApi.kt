package com.example.mobonews.data.api

import com.example.mobonews.data.api.entity.DiscoverDetailEntity
import retrofit2.Response
import retrofit2.http.GET

interface DiscoverApi {


    @GET("get_discover_detail.php")
    suspend fun getDiscoverDetail(): Response<DiscoverDetailEntity>


}