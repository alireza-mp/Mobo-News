package com.example.mobonews.presentation.ui.bottomNavigationPages.homePage.recommended

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobonews.domain.model.FavoriteNews
import com.example.mobonews.domain.model.HotNews
import com.example.mobonews.domain.useCase.GetRecommendedUseCase
import com.example.mobonews.util.DataState
import com.example.mobonews.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendedViewModel
@Inject
constructor(
    private val useCase: GetRecommendedUseCase,
) : ViewModel() {

    var uiState by mutableStateOf<UiState>(UiState.Loading)
        private set

    private val _favoriteNewsList = mutableStateListOf<FavoriteNews>()
    val favoriteNewsList: List<FavoriteNews> = _favoriteNewsList
    private val _hotNewsList = mutableStateListOf<HotNews>()
    val hotNewsList: List<HotNews> = _hotNewsList
    var isLaunchAnimation = true


    init {
        initialData()
    }

    fun initialData() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase().onEach {
                uiState = when (it) {
                    is DataState.Loading -> {
                        UiState.Loading
                    }
                    is DataState.Success -> {
                        _favoriteNewsList.addAll(it.data.FavoriteNewsList)
                        _hotNewsList.addAll(it.data.HotNewsList)
                        UiState.Success
                    }
                    is DataState.Error -> {
                        UiState.Error
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}