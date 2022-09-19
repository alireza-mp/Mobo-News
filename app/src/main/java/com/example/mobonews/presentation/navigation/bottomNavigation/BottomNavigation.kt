package com.example.mobonews.presentation.navigation.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobonews.presentation.ui.bottomNavigationPages.addNewPage.AddNewPage
import com.example.mobonews.presentation.ui.bottomNavigationPages.discoverPage.DiscoverPage
import com.example.mobonews.presentation.ui.bottomNavigationPages.homePage.home.HomePage
import com.example.mobonews.presentation.ui.bottomNavigationPages.profilePage.ProfilePage
import com.example.mobonews.presentation.ui.bottomNavigationPages.savePage.SavePage
import com.example.mobonews.presentation.ui.newsDetail.NewsDetailPage

@Composable
fun MainBottomNavigation(
    bottomNavController: NavHostController, //main page bottom navigation controller
) {

    NavHost(
        navController = bottomNavController,
        startDestination = BottomNavigationTabs.Home.screenRoute,
    ) {

        composable(route = BottomNavigationTabs.Home.screenRoute) {
            HomePage(bottomNavController)
        }

        composable(route = BottomNavigationScreens.NewsDetail.route) { backStackEntry ->
            val newsId = backStackEntry.arguments?.getString("newsId") ?: "0"
            NewsDetailPage(newsId = newsId)
        }

        composable(BottomNavigationTabs.Discover.screenRoute) {
            DiscoverPage(bottomNavController)
        }
        composable(BottomNavigationTabs.AddNew.screenRoute) {
            AddNewPage(bottomNavController)
        }
        composable(BottomNavigationTabs.Save.screenRoute) {
            SavePage(bottomNavController)
        }
        composable(BottomNavigationTabs.Profile.screenRoute) {
            ProfilePage(bottomNavController)
        }
    }
}