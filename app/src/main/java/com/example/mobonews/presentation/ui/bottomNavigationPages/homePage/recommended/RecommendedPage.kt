package com.example.mobonews.presentation.ui.bottomNavigationPages.homePage.recommended

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mobonews.presentation.navigation.bottomNavigation.BottomNavigationScreens
import com.example.mobonews.presentation.ui.components.*
import com.example.mobonews.util.UiState

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
            padding = PaddingValues(horizontal = 16.dp),
            title = "خبر های داغ",
            onClick = {},
        )


        // hot news list

        Spacer(modifier = Modifier.padding(top = 8.dp))
        HotNewsList(viewModel, navHostController)


        // favorite news title

        Spacer(modifier = Modifier.padding(top = 8.dp))
        ListTitle(
            padding = PaddingValues(horizontal = 16.dp),
            title = "خبر هایی که علاقه داری",
            onClick = {},
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))


        // favorite news list
        FavoriteNewsList(viewModel, navHostController)

    }
}

@Composable
private fun FavoriteNewsList(
    viewModel: RecommendedViewModel,
    navHostController: NavHostController,
) {
    viewModel.favoriteNewsList.forEachIndexed { _, item ->
        FavoriteNewsItem(
            modifier = Modifier.padding(horizontal = 16.dp),
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
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 16.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        viewModel.hotNewsList.forEachIndexed { _, item ->
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