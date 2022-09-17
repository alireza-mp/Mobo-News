package com.example.mobonews.domain.useCase

import com.example.mobonews.domain.repository.NewsDetailRepository
import javax.inject.Inject

class GetNewsDetailUseCase
@Inject
constructor(
    private val newsDetailRepository: NewsDetailRepository,
) {

    suspend operator fun invoke(newsId: Int) = newsDetailRepository.getNewsDetail(newsId)

}