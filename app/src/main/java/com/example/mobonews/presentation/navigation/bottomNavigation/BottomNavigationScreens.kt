package com.example.mobonews.presentation.navigation.bottomNavigation

sealed class BottomNavigationScreens(val route: String) {

    object Home : BottomNavigationScreens("home")
    object Discover : BottomNavigationScreens("discover")
    object AddNew : BottomNavigationScreens("add_new")
    object Save : BottomNavigationScreens("save")
    object Profile : BottomNavigationScreens("profile")

    object NewsDetail : BottomNavigationScreens("news_detail_page/{newsId}") {
        fun createNewsIdRoute(newsId: String) = "news_detail_page/$newsId"
    }

}