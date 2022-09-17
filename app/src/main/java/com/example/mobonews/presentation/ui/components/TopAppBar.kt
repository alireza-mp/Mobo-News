package com.example.mobonews.presentation.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mobonews.R
import com.example.mobonews.presentation.navigation.bottomNavigation.MainBNScreens
import com.example.mobonews.presentation.navigation.homePageNavigation.HomePageNavigationScreens


@Composable
fun TopAppBar(
    bottomNavController: NavHostController,
    homePageNavState: MutableState<String>,
) {
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()

    when (navBackStackEntry?.destination?.route ?: "") {
        MainBNScreens.Home.screenRoute -> {
            HomePageAppBar(homePageNavState)
        }
        MainBNScreens.Discover.screenRoute -> {
            DiscoverPageAppBar()
        }
        else -> {
            DiscoverPageAppBar()
        }
    }
}

@Composable
private fun HomePageAppBar(homePageNavState: MutableState<String>) {
    // if current route is home page visible app bar
    AnimatedVisibility(
        visible = homePageNavState.value == HomePageNavigationScreens.Home.route,
        enter = fadeIn() + slideInVertically(),
        exit = fadeOut() + slideOutVertically()
    ) {
        HomeAppBarContent()
    }

}

@Composable
private fun HomeAppBarContent() {
    Box(
        modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 16.dp),
    ) {


        CustomIconButton(
            modifier = Modifier.align(Alignment.CenterEnd),
            id = R.drawable.ic_notifications,
            onClick = {},
        )
        Image(
            modifier = Modifier.height(40.dp)
                .align(Alignment.Center),
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
        )
    }
}

@Composable
private fun DiscoverPageAppBar() {
    Box(
        modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
        ) {
            CustomIconButton(
                id = R.drawable.ic_filter,
                onClick = {}
            )
            Spacer(modifier = Modifier.padding(end = 20.dp))
            CustomIconButton(
                id = R.drawable.ic_search,
                onClick = {}
            )
        }
        Image(
            modifier = Modifier.height(40.dp)
                .align(Alignment.Center),
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
        )
    }
}