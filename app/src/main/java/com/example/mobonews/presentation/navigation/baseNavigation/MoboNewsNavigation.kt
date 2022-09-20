package com.example.mobonews.presentation.navigation.baseNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobonews.presentation.ui.mainPage.MainPage
import com.example.mobonews.presentation.ui.splashPage.SplashPage

@Composable
fun MoboNewsNavigation(navController: NavHostController, bottomNavController: NavHostController) {


    NavHost(
        navController = navController,
        startDestination = Screens.SplashPage.route,
    ) {
        composable(route = Screens.SplashPage.route) {
            SplashPage(navController)
        }
        composable(route = Screens.MainPage.route) {
            MainPage(bottomNavController)
        }
    }
}