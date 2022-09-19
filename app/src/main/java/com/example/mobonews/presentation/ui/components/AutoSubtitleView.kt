package com.example.mobonews.presentation.ui.components

import AutoScroollingText
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mobonews.presentation.navigation.bottomNavigation.BottomNavigationTabs

@Composable
fun AutoSubtitel(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    text: String,
    color: Color,
    style: TextStyle,
) {

    val backStackEntry = navController.currentBackStackEntryAsState()
    AnimatedVisibility(
        modifier = modifier,
        visible = (backStackEntry.value?.destination?.route ?: "") ==
                BottomNavigationTabs.Discover.screenRoute,
        enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 }), //from bottom to top
        exit = fadeOut() + slideOutVertically(targetOffsetY = { it / 2 }), // from top to bottom
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(50.dp)
                .background(color = MaterialTheme.colors.primary),
            contentAlignment = Alignment.Center,
        ) {
            AutoScroollingText(
                text = text,
                color = color,
                style = style,
            )
        }
    }
}
