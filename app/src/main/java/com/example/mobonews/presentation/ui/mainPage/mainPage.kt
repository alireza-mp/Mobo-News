package com.example.mobonews.presentation.ui.mainPage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.mobonews.presentation.navigation.bottomNavigation.MainBottomNavigation
import com.example.mobonews.presentation.ui.components.BottomNavigation

@Composable
fun MainPage() {

    // bottom navigation controller
    val bNavigationController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = { BottomNavigation(bNavigationController) }
    ) {
        Box(Modifier.fillMaxSize().padding(it)) {
            MainBottomNavigation(bNavigationController)
        }
    }


}