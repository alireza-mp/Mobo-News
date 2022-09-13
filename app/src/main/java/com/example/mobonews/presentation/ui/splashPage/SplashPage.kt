package com.example.mobonews.presentation.ui.splashPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mobonews.R
import com.example.mobonews.presentation.navigation.baseNavigation.Screens
import com.example.mobonews.presentation.ui.components.BallProgress
import kotlinx.coroutines.delay

@Composable
fun SplashPage(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.background)) {

        Image(
            modifier = Modifier.size(120.dp).align(Alignment.Center),
            painter = painterResource(R.drawable.logo),
            contentDescription = null
        )

        BallProgress(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 36.dp),
        )
    }

    LaunchedEffect(Unit) {
        delay(1000)
        navController.navigate(Screens.MainPage.route){
            popUpTo(Screens.SplashPage.route) {
                inclusive = true
            }
        }
    }

}