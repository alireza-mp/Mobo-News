package com.example.mobonews.di

import com.example.mobonews.domain.repository.DiscoverRepository
import com.example.mobonews.domain.repository.NewsDetailRepository
import com.example.mobonews.domain.repository.NewsRepository
import com.example.mobonews.domain.useCase.GetDiscoverDetailUseCase
import com.example.mobonews.domain.useCase.GetNewsDetailUseCase
import com.example.mobonews.domain.useCase.GetRecommendedUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetRecommendedUseCase(
        newsRepository: NewsRepository,
    ): GetRecommendedUseCase {
        return GetRecommendedUseCase(newsRepository)
    }

    @Provides
    fun provideGetNewsDetailUseCase(
        newsDetailRepository: NewsDetailRepository,
    ): GetNewsDetailUseCase {
        return GetNewsDetailUseCase(newsDetailRepository)
    }

    @Provides
    fun provideGetDiscoverDetailRepository(
        discoverRepository: DiscoverRepository,
    ): GetDiscoverDetailUseCase {
        return GetDiscoverDetailUseCase(discoverRepository)
    }

}