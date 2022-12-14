package com.example.mobonews.presentation.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mobonews.R
import com.example.mobonews.presentation.navigation.bottomNavigation.BottomNavigationScreens


@Composable
fun TopAppBar(
    bottomNavController: NavHostController,
) {

    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    AnimatedVisibility(
        visible = currentRoute != BottomNavigationScreens.NewsDetail.route, // gone appBar from news detail page
        enter = fadeIn() + slideInVertically(),
        exit = fadeOut() + slideOutVertically()
    ) {
        AppBarContent(currentRoute)
    }
}


@Composable
private fun AppBarContent(currentRoute: String?) {
    when (currentRoute ?: "") {
        BottomNavigationScreens.Home.route -> {
            HomePageAppBar()
        }
        BottomNavigationScreens.Discover.route -> {
            DiscoverPageAppBar()
        }
        else -> {
            /* addNew & profile & save app bar */
        }
    }

}

@Composable
private fun HomePageAppBar() {
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