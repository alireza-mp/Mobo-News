package com.example.mobonews.presentation.ui.bottomNavigationPages.discoverPage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mobonews.presentation.theme.White
import com.example.mobonews.presentation.ui.components.*
import com.example.mobonews.util.Categories
import com.example.mobonews.util.UiState

@Composable
fun DiscoverPage(
    navHostController: NavHostController,
) {
    val viewModel: DiscoverViewModel = hiltViewModel()
    when (viewModel.uiState) {
        UiState.Loading -> {
            BallProgressView()
        }
        UiState.Success -> {
            Content(navHostController, viewModel)
        }
        UiState.Error -> {
            ErrorView {
                viewModel.initialData()
            }
        }
    }
}

@Composable
private fun Content(
    navHostController: NavHostController,
    viewModel: DiscoverViewModel,
) {


    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(color = MaterialTheme.colors.background)
                .verticalScroll(rememberScrollState()),
        ) {

            Spacer(modifier = Modifier.padding(top = 16.dp))
            CustomImagePager(
                padding = PaddingValues(horizontal = 16.dp),
                imagesUrl = viewModel.bannerUrls
            )

            Spacer(modifier = Modifier.padding(top = 16.dp))
            LazyRow(modifier = Modifier.fillMaxWidth().padding(start = 16.dp)) {
                itemsIndexed(
                    items = Categories.getCategoriesAsList(),
                    key = { _, item -> item.title },
                ) { _, item ->

                    Chips(
                        modifier = Modifier.padding(end = 12.dp),
                        title = item.title,
                        enabled = viewModel.selectedCategory.title == item.title,
                        onClick = { viewModel.onCategoryClick(item) }
                    )
                }
            }

            // publishers list title
            Spacer(modifier = Modifier.padding(top = 8.dp))
            ListTitle(
                padding = PaddingValues(horizontal = 16.dp),
                title = "خبرگزاری ها",
                onClick = {},
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))


            // publishers list
            PublishersList(viewModel)


            // secretary's proposal list title
            Spacer(modifier = Modifier.padding(top = 8.dp))
            ListTitle(
                padding = PaddingValues(horizontal = 16.dp),
                title = "پیشنهاد سردبیر",
                onClick = {},
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))

            NewsList(viewModel)

            Spacer(modifier = Modifier.padding(bottom = 62.dp))
        }

        AutoSubtitel(
            modifier = Modifier.align(Alignment.BottomCenter),
            navController = navHostController,
            text = viewModel.subtitle,
            color = MaterialTheme.colors.White,
            style = MaterialTheme.typography.h2,
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PublishersList(viewModel: DiscoverViewModel) {
    LazyRow(modifier = Modifier.fillMaxWidth().padding(start = 16.dp)) {
        itemsIndexed(
            items = viewModel.publishersList,
            key = { _, item -> item.id },
        ) { _, item ->
            PublisherItem(
                modifier = Modifier.padding(end = 16.dp)
                    .animateItemPlacement(),
                model = item,
                onClick = {

                })
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewsList(viewModel: DiscoverViewModel) {
    LazyRow(modifier = Modifier.fillMaxWidth().padding(start = 16.dp)) {
        itemsIndexed(
            items = viewModel.newsList,
            key = { _, item -> item.id },
        ) { _, item ->
            HotNewsItem(
                modifier = Modifier.animateItemPlacement(),
                model = item,
                onClick = {}
            )
        }
    }
}