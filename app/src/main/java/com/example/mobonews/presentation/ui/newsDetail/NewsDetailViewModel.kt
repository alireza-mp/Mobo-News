package com.example.mobonews.presentation.ui.newsDetail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobonews.domain.model.NewsDetail
import com.example.mobonews.domain.useCase.GetNewsDetailUseCase
import com.example.mobonews.util.DataState
import com.example.mobonews.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel
@Inject
constructor(
    private val useCase: GetNewsDetailUseCase,
) : ViewModel() {

    val newsDetail: MutableState<NewsDetail?> = mutableStateOf(null)
    val uiState = mutableStateOf(UiState.Loading)

    // get news detail
    fun initialData(newsId: Int) {
        viewModelScope.launch {
            useCase(newsId).collect {
                uiState.value = when (it) {
                    is DataState.Loading -> {
                        UiState.Loading
                    }
                    is DataState.Success -> {
                        newsDetail.value = it.data
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