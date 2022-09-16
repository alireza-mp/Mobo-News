package com.example.mobonews.presentation.navigation.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobonews.presentation.navigation.homePageNavigation.HomePageNavigation
import com.example.mobonews.presentation.ui.bottomNavigationPages.addNewPage.AddNewPage
import com.example.mobonews.presentation.ui.bottomNavigationPages.discoverPage.DiscoverPage
import com.example.mobonews.presentation.ui.bottomNavigationPages.profilePage.ProfilePage
import com.example.mobonews.presentation.ui.bottomNavigationPages.savePage.SavePage

@Composable
fun MainBottomNavigation(
    bNavigationController: NavHostController, //main page bottom navigation controller
    homePageNavState: MutableState<String>,
) {

    NavHost(
        navController = bNavigationController,
        startDestination = MainBNScreens.Home.screenRoute,
    ) {
        composable(
            route = MainBNScreens.Home.screenRoute,
        ) {
            HomePageNavigation(homePageNavState)
        }
        composable(MainBNScreens.Discover.screenRoute) {
            DiscoverPage(bNavigationController)
        }
        composable(MainBNScreens.AddNew.screenRoute) {
            AddNewPage(bNavigationController)
        }
        composable(MainBNScreens.Save.screenRoute) {
            SavePage(bNavigationController)
        }
        composable(MainBNScreens.Profile.screenRoute) {
            ProfilePage(bNavigationController)
        }
    }
}