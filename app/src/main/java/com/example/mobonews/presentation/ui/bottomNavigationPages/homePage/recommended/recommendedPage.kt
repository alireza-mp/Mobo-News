package com.example.mobonews.presentation.ui.bottomNavigationPages.homePage.recommended

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mobonews.presentation.navigation.homePageNavigation.HomePageNavigationScreens
import com.example.mobonews.presentation.ui.components.BallProgress
import com.example.mobonews.presentation.ui.components.ErrorView
import com.example.mobonews.util.UiState

@Composable
fun RecommendedPage(
    navHostController: NavHostController,
) {

    val viewModel: RecommendedViewModel = hiltViewModel()

    when (viewModel.uiState.value) {
        UiState.Loading -> {
            // progress view
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                BallProgress()
            }
        }
        UiState.Success -> {
            Content(viewModel, navHostController)
        }
        UiState.Error -> {
            // error view
            ErrorView(
                onRetry = {
                    viewModel.initialData()
                },
            )
        }
    }
}

@Composable
private fun Content(viewModel: RecommendedViewModel, navHostController: NavHostController) {

    val favoriteNewsList = remember { viewModel.favoriteNewsList }
    val hotNewsList = remember { viewModel.hotNewsList }

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        // hot news title
        item {
            Spacer(modifier = Modifier.padding(top = 4.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "خبر های داغ",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.primaryVariant,
                )
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = {

                }) {
                    Text(
                        text = "مشاهده بیشتر",
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.primary,
                    )
                }
            }
        }

        // hot news list
        item {
            Spacer(modifier = Modifier.padding(top = 8.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                itemsIndexed(
                    items = hotNewsList,
                    key = { _, item -> item.id },
                ) { _, item ->
                    HotNewsItem(
                        model = item,
                        onClick = {
                            navHostController.navigate(
                                HomePageNavigationScreens.NewsDetail.createNewsIdRoute(
                                    newsId = item.newsId.toString(),
                                ),
                            )
                        }
                    )
                }
            }
        }

        // favorite news title
        item {
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "خبر هایی که علاقه داری",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.primaryVariant,
                )
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = {

                }) {
                    Text(
                        text = "مشاهده بیشتر",
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.primary,
                    )
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
        }

        // favorite news list
        itemsIndexed(items = favoriteNewsList, key = { _, item -> item.id }) { _, item ->
            FavoriteNewsItem(
                modifier = Modifier.padding(horizontal = 16.dp),
                model = item,
                onClick = {
                    navHostController.navigate(
                        HomePageNavigationScreens.NewsDetail.createNewsIdRoute(
                            newsId = item.newsId.toString(),
                        ),
                    )
                }
            )
        }
    }
}
