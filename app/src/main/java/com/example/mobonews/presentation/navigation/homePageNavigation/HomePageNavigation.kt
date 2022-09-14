package com.example.mobonews.presentation.navigation.homePageNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobonews.presentation.ui.bottomNavigationPages.homePage.home.HomePage
import com.example.mobonews.presentation.ui.newsDetail.NewsDetail

@Composable
fun HomePageNavigation() {

    val homePageNavHost = rememberNavController()

    NavHost(
        navController = homePageNavHost,
        startDestination = HomePageNavigationScreens.Home.route,
    ) {
        composable(route = HomePageNavigationScreens.Home.route) {
            HomePage(homePageNavHost)
        }
        composable(route = HomePageNavigationScreens.NewsDetail.route) {
            NewsDetail()
        }
    }

}