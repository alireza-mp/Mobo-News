package com.example.mobonews.presentation.navigation.baseNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobonews.presentation.ui.splashPage.SplashPage

@Composable
fun MoboNewsNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.SplashPage.route,
    ) {
        composable(route = Screens.SplashPage.route) {
            SplashPage(navController)
        }
    }

}