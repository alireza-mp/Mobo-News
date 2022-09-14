package com.example.mobonews.presentation.ui.bottomNavigationPages.homePage.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mobonews.presentation.ui.bottomNavigationPages.homePage.flowing.FlowIngPage
import com.example.mobonews.presentation.ui.bottomNavigationPages.homePage.recommended.RecommendedPage
import com.example.mobonews.presentation.ui.components.CustomTabRow
import com.example.mobonews.presentation.ui.components.TabState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePage(
    homePageNavHost: NavHostController,
) {
    val tabState = remember { mutableStateOf(TabState.Recommended) }
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    // header
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        Spacer(modifier = Modifier.padding(top = 16.dp))
        // tab row
        CustomTabRow(
            tabState = tabState.value,
            onTabClick = { index ->
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            })

        Spacer(modifier = Modifier.padding(top = 12.dp))
        // pager
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            count = 2,
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> {
                    RecommendedPage()
                }
                1 -> {
                    FlowIngPage()
                }
            }
        }

        // update tabRow state when page scrolled
        LaunchedEffect(pagerState.currentPage) {
            if (pagerState.currentPage == 0) {
                tabState.value = TabState.Recommended
            } else {
                tabState.value = TabState.Flowing
            }
        }
    }
}



