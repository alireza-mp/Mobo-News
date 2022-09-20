package com.example.mobonews.presentation.ui.bottomNavigationPages.homePage.recommended

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mobonews.presentation.navigation.bottomNavigation.BottomNavigationScreens
import com.example.mobonews.presentation.ui.components.*
import com.example.mobonews.util.UiState
import kotlinx.coroutines.delay

@Composable
fun RecommendedPage(
    navHostController: NavHostController,
) {

    val viewModel: RecommendedViewModel = hiltViewModel()
    when (viewModel.uiState) {
        UiState.Loading -> {
            // progress view
            BallProgressView()
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

    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {

        // hot news title

        Spacer(modifier = Modifier.padding(top = 4.dp))
        ListTitle(
            Modifier.alphaAnimation(
                enabled = viewModel.isLaunchAnimation,
                delay = 250,
                duration = 1000,
            ),
            padding = PaddingValues(horizontal = 16.dp),
            title = "خبر های داغ",
            onClick = {},
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))
        // hot news list
        HotNewsList(viewModel, navHostController)

        Spacer(modifier = Modifier.padding(top = 8.dp))
        // favorite news title
        ListTitle(
            modifier = Modifier.alphaAnimation(
                enabled = viewModel.isLaunchAnimation,
                delay = 750,
                duration = 1000,
            ),
            padding = PaddingValues(horizontal = 16.dp),
            title = "خبر هایی که علاقه داری",
            onClick = {},
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))

        // favorite news list
        FavoriteNewsList(viewModel, navHostController)

    }

    // disable first launch animation
    LaunchedEffect(Unit) {
        delay(1200)
        viewModel.isLaunchAnimation = false
    }
}

@Composable
private fun FavoriteNewsList(
    viewModel: RecommendedViewModel,
    navHostController: NavHostController,
) {
    viewModel.favoriteNewsList.forEachIndexed { _, item ->
        FavoriteNewsItem(
            modifier = Modifier.padding(horizontal = 16.dp)
                .alphaAnimation(
                    enabled = viewModel.isLaunchAnimation,
                    delay = 1000,
                    duration = 1000,
                ),
            model = item,
            onClick = {
                // navigate to news detail page
                navHostController.navigate(
                    BottomNavigationScreens.NewsDetail.createNewsIdRoute(
                        newsId = item.newsId.toString(),
                    ),
                )
            }
        )
    }
}

@Composable
private fun HotNewsList(viewModel: RecommendedViewModel, navHostController: NavHostController) {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
            .alphaAnimation(
                enabled = viewModel.isLaunchAnimation,
                delay = 500,
                duration = 1000,
            )
            .padding(start = 16.dp)
    ) {
        itemsIndexed(items = viewModel.hotNewsList, key = { _, item -> item.id }) { _, item ->
            HotNewsItem(
                model = item,
                onClick = {
                    // navigate to news detail page
                    navHostController.navigate(
                        BottomNavigationScreens.NewsDetail.createNewsIdRoute(
                            newsId = item.newsId.toString(),
                        ),
                    )
                }
            )
        }
    }
}