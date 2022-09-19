package com.example.mobonews.di

import com.example.mobonews.data.repository.DiscoverRepositoryImpl
import com.example.mobonews.data.repository.NewsRepositoryImpl
import com.example.mobonews.data.repository.dataSource.DiscoverRemoteDataSource
import com.example.mobonews.data.repository.dataSource.NewsRemoteDataSource
import com.example.mobonews.data.repository.dataSourceImpl.NewsDetailRepositoryImpl
import com.example.mobonews.domain.repository.DiscoverRepository
import com.example.mobonews.domain.repository.NewsDetailRepository
import com.example.mobonews.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideNewsDetailRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
    ): NewsDetailRepository {
        return NewsDetailRepositoryImpl(newsRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideDiscoverRepository(
        discoverRemoteDataSource: DiscoverRemoteDataSource,
    ): DiscoverRepository {
        return DiscoverRepositoryImpl(discoverRemoteDataSource)
    }

}