package com.example.mobonews.presentation.navigation.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobonews.presentation.ui.bottomNavigationPages.addNewPage.AddNewPage
import com.example.mobonews.presentation.ui.bottomNavigationPages.discoverPage.DiscoverPage
import com.example.mobonews.presentation.ui.bottomNavigationPages.homePage.HomePage
import com.example.mobonews.presentation.ui.bottomNavigationPages.profilePage.ProfilePage
import com.example.mobonews.presentation.ui.bottomNavigationPages.savePage.SavePage

@Composable
fun MainBottomNavigation(bNavigationController: NavHostController) {

    NavHost(
        navController = bNavigationController,
        startDestination = MainBNScreens.Home.screen_route,
    ) {
        composable(MainBNScreens.Home.screen_route) {
            HomePage(bNavigationController)
        }
        composable(MainBNScreens.Discover.screen_route) {
            DiscoverPage(bNavigationController)
        }
        composable(MainBNScreens.AddNew.screen_route) {
            AddNewPage(bNavigationController)
        }
        composable(MainBNScreens.Save.screen_route) {
            SavePage(bNavigationController)
        }
        composable(MainBNScreens.Profile.screen_route) {
            ProfilePage(bNavigationController)
        }
    }
}