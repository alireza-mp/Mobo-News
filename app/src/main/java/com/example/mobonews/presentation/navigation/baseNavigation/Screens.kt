package com.example.mobonews.presentation.navigation.baseNavigation

sealed class Screens(val route: String) {

    object SplashPage : Screens("splash_page")
    object MainPage : Screens("main_page")

}
