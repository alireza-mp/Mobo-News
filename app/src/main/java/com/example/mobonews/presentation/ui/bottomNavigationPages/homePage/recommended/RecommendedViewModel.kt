package com.example.mobonews.presentation.ui.bottomNavigationPages.homePage.recommended

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobonews.domain.model.FavoriteNews
import com.example.mobonews.domain.model.HotNews
import com.example.mobonews.domain.useCase.GetRecommendedUseCase
import com.example.mobonews.util.DataState
import com.example.mobonews.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendedViewModel
@Inject
constructor(
    private val useCase: GetRecommendedUseCase,
) : ViewModel() {

    var uiState = mutableStateOf(UiState.Loading)
    val favoriteNewsList = mutableStateListOf<FavoriteNews>()
    val hotNewsList = mutableStateListOf<HotNews>()


    init {
        initialData()
    }

    fun initialData() {
        viewModelScope.launch {
            useCase().collect {
                uiState.value = when (it) {
                    is DataState.Loading -> {
                        UiState.Loading
                    }
                    is DataState.Success -> {
                        favoriteNewsList.addAll(it.data.FavoriteNewsList)
                        hotNewsList.addAll(it.data.HotNewsList)
                        UiState.Success
                    }
                    is DataState.Error -> {
                        UiState.Error
                    }
                }
            }
        }
    }
}