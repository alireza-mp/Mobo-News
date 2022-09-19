package com.example.mobonews.presentation.ui.bottomNavigationPages.discoverPage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobonews.domain.model.DiscoverDetail
import com.example.mobonews.domain.model.HotNews
import com.example.mobonews.domain.model.Publisher
import com.example.mobonews.domain.useCase.GetDiscoverDetailUseCase
import com.example.mobonews.util.Categories
import com.example.mobonews.util.DataState
import com.example.mobonews.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel
@Inject
constructor(
    private val useCase: GetDiscoverDetailUseCase,
) : ViewModel() {

    private val _newsList = mutableStateListOf<HotNews>()
    val newsList: List<HotNews> = _newsList
    private val _publishersList = mutableStateListOf<Publisher>()
    val publishersList: List<Publisher> = _publishersList
    private val _bannerUrls = mutableStateListOf<String>()
    val bannerUrls: List<String> = _bannerUrls

    var uiState by mutableStateOf<UiState>(UiState.Loading)
        private set
    var subtitle by mutableStateOf<String>("")
        private set
    var selectedCategory by mutableStateOf(Categories.All)
        private set

    private var details: DiscoverDetail? = null


    init {
        initialData()
    }

    fun initialData() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase().onEach {
                when (it) {
                    is DataState.Loading -> {
                        uiState = UiState.Loading
                    }
                    is DataState.Success -> {
                        details = it.data
                        filterList(details)
                        _bannerUrls.addAll(it.data.bannerUrls)
                        subtitle = it.data.subtitle
                        uiState = UiState.Success
                    }
                    is DataState.Error -> {
                        uiState = UiState.Error
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    fun onCategoryClick(item: Categories) {
        selectedCategory = item
        filterList(details)
    }

    private fun filterList(detail: DiscoverDetail?) {
        detail?.let {
            // clear lists items
            _newsList.clear()
            _publishersList.clear()
            // filter list by category
            if (selectedCategory != Categories.All) {
                _newsList.addAll(detail.newsList.filter { item -> item.category == selectedCategory.title })
                _publishersList.addAll(detail.publishers.filter { item -> item.category == selectedCategory.title })
            } else {
                _newsList.addAll(detail.newsList)
                _publishersList.addAll(detail.publishers)
            }
        }
    }

}