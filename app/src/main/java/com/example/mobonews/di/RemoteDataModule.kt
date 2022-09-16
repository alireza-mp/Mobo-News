package com.example.mobonews.di

import com.example.mobonews.data.api.NewsApi
import com.example.mobonews.data.repository.dataSource.NewsRemoteDataSource
import com.example.mobonews.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsApi: NewsApi,
    ): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApi)
    }

}