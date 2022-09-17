package com.example.mobonews.presentation.navigation.homePageNavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mobonews.presentation.ui.bottomNavigationPages.homePage.home.HomePage
import com.example.mobonews.presentation.ui.newsDetail.NewsDetailPage

@Composable
fun HomePageNavigation(
    homePageState: MutableState<String>,
) {

    val homePageNavHost = rememberNavController()
    val navBackStackEntry by homePageNavHost.currentBackStackEntryAsState()
    homePageState.value = navBackStackEntry?.destination?.route ?: ""

    NavHost(
        navController = homePageNavHost,
        startDestination = HomePageNavigationScreens.Home.route,
    ) {
        composable(route = HomePageNavigationScreens.Home.route) {
            HomePage(homePageNavHost)
        }
        composable(route = HomePageNavigationScreens.NewsDetail.route) { backStackEntry ->
            val newsId = backStackEntry.arguments?.getString("newsId") ?: "0"
            NewsDetailPage(newsId = newsId)
        }
    }

}