package com.example.mobonews.presentation.navigation.homePageNavigation


sealed class HomePageNavigationScreens(val route: String) {
    object Home : HomePageNavigationScreens("home_page")
    object NewsDetail : HomePageNavigationScreens("news_detail_page")
}