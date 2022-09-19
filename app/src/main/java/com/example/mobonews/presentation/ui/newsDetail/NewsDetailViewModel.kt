package com.example.mobonews.presentation.ui.newsDetail

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobonews.domain.model.NewsDetail
import com.example.mobonews.domain.useCase.GetNewsDetailUseCase
import com.example.mobonews.util.DataState
import com.example.mobonews.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel
@Inject
constructor(
    private val useCase: GetNewsDetailUseCase,
) : ViewModel() {

    private val _newsDetail: MutableState<NewsDetail?> = mutableStateOf(null)
    val newsDetail: State<NewsDetail?> = _newsDetail
    var uiState by mutableStateOf(UiState.Loading)
        private set

    // get news detail
    fun initialData(newsId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase(newsId).onEach {
                uiState = when (it) {
                    is DataState.Loading -> {
                        UiState.Loading
                    }
                    is DataState.Success -> {
                        _newsDetail.value = it.data
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