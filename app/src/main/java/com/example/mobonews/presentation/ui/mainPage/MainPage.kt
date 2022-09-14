package com.example.mobonews.presentation.ui.mainPage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        Surface(
            modifier = Modifier.padding(it),
            color = MaterialTheme.colors.background,
        ) {
            Box(
                modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center,
            ) {
                MainBottomNavigation(bNavigationController)
            }
        }
    }

}