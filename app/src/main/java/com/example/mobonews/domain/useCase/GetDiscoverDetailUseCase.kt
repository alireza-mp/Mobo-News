package com.example.mobonews.domain.useCase

import com.example.mobonews.domain.repository.DiscoverRepository
import javax.inject.Inject

class GetDiscoverDetailUseCase
@Inject
constructor(
    private val repository: DiscoverRepository,
) {

    suspend operator fun invoke() = repository.getDiscoverDetail()

}