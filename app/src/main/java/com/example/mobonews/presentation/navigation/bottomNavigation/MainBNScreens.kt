package com.example.mobonews.presentation.navigation.bottomNavigation

import com.example.mobonews.R

//main bottom navigation screens
sealed class MainBNScreens(var icon: Int, var enabledIcon: Int, var screen_route: String) {

    object Home :
        MainBNScreens(R.drawable.ic_home, R.drawable.ic_home_enabled, "home")

    object Discover :
        MainBNScreens(R.drawable.ic_discover, R.drawable.ic_discover_enabled, "discover")

    object AddNew :
        MainBNScreens(R.drawable.ic_add, R.drawable.ic_add_enabled, "add_new")

    object Save :
        MainBNScreens(R.drawable.ic_save, R.drawable.ic_save_enabled, "save")

    object Profile :
        MainBNScreens(R.drawable.ic_profile, R.drawable.ic_profile_enabled, "profile")
}

