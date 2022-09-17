package com.example.mobonews.presentation.ui.mainPage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.mobonews.presentation.navigation.bottomNavigation.MainBottomNavigation
import com.example.mobonews.presentation.navigation.homePageNavigation.HomePageNavigationScreens
import com.example.mobonews.presentation.ui.components.BottomNavigation
import com.example.mobonews.presentation.ui.components.TopAppBar

@Composable
fun MainPage() {

    // bottom navigation controller
    val bNavigationController = rememberNavController()
    // home page navigation controller
    val homePageNavState = remember { mutableStateOf(HomePageNavigationScreens.Home.route) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            TopAppBar(
                bottomNavController = bNavigationController,
                homePageNavState = homePageNavState,
            )
        },
        bottomBar = { BottomNavigation(navController = bNavigationController) }
    ) {
        Surface(
            modifier = Modifier.padding(it),
            color = MaterialTheme.colors.background,
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                MainBottomNavigation(
                    bNavigationController = bNavigationController,
                    homePageNavState = homePageNavState
                )
            }
        }
    }

}