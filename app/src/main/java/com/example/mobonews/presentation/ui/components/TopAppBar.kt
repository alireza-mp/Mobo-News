package com.example.mobonews.presentation.ui.components

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
import com.example.mobonews.presentation.navigation.bottomNavigation.MainBNScreens


@Composable
fun TopAppBar(
    navController: NavHostController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Box(
        modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 16.dp),
    ) {
        when (navBackStackEntry?.destination?.route ?: "") {
            MainBNScreens.Home.screenRoute -> {
                CustomIconButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    id = R.drawable.ic_notifications,
                    onClick = {},
                )
            }
            MainBNScreens.Discover.screenRoute -> {
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
            }
        }
        Image(
            modifier = Modifier.height(40.dp)
                .align(Alignment.Center),
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
        )
    }
}
