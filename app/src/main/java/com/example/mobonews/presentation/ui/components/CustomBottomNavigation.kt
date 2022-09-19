package com.example.mobonews.presentation.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mobonews.presentation.navigation.bottomNavigation.BottomNavigationScreens
import com.example.mobonews.presentation.navigation.bottomNavigation.BottomNavigationTabs
import com.example.mobonews.presentation.theme.bottomNavigationSelector


@Composable
fun BottomNavigation(
    bottomNavController: NavHostController,
) {
    BoxWithConstraints {
        val numberOfTabs = 5
        val selectorWidth = 50
        val selectorHeight = 10
        val spaceBetweenTabs = (maxWidth / numberOfTabs.dp)
        val firstPoint = ((spaceBetweenTabs - selectorWidth) / 2)
        val tabsPoint = mutableListOf<Float>()
        for (tabNumber in 0 until numberOfTabs) {
            tabsPoint.add(firstPoint + (spaceBetweenTabs * tabNumber))
        }
        val items = listOf(
            BottomNavigationTabs.Home,
            BottomNavigationTabs.Discover,
            BottomNavigationTabs.AddNew,
            BottomNavigationTabs.Save,
            BottomNavigationTabs.Profile,
        )
        Content(
            bottomNavController,
            tabsPoint,
            items,
            selectorHeight,
            selectorWidth
        )
    }
}


@Composable
private fun Content(
    navController: NavHostController,
    tabsPoint: List<Float>,
    items: List<BottomNavigationTabs>,
    selectorHeight: Int,
    selectorWidth: Int,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val selectorXPointState = remember { mutableStateOf(tabsPoint[0].dp) }

    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    if (
                        currentRoute == item.screenRoute ||
                        // enable home icon from news detail page
                        (currentRoute == BottomNavigationScreens.NewsDetail.route && index == 0)
                    ) {
                        Image(painterResource(id = item.enabledIcon),
                            contentDescription = null)
                    } else {
                        Icon(painterResource(id = item.icon),
                            contentDescription = null)
                    }
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.secondary,
                selected = currentRoute == item.screenRoute,
                onClick = {

                    selectorXPointState.value = tabsPoint[index].dp

                    navController.navigate(items[index].screenRoute) {

                        popUpTo(currentRoute ?: "") {
                            saveState = true
                            inclusive = true

                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }

    SelectorUI(
        selectorWidth = selectorWidth,
        selectorHeight = selectorHeight,
        selectorXPointState = selectorXPointState.value,
    )

}

@Composable
private fun SelectorUI(
    selectorWidth: Int,
    selectorHeight: Int,
    selectorXPointState: Dp,
) {

    val selectorXAnim by animateDpAsState(
        targetValue = selectorXPointState,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        )
    )
    // selector
    Card(
        modifier = Modifier.size(width = selectorWidth.dp, height = selectorHeight.dp)
            .offset(x = selectorXAnim)
            .coloredShadow(
                color = MaterialTheme.colors.primary,
                alpha = 0.6f,
                borderRadius = 0.dp,
                shadowRadius = 20.dp,
                offsetY = 10.dp,
                offsetX = 0.dp,
            ),
        shape = MaterialTheme.shapes.bottomNavigationSelector,
        backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.7f),

        ) {}
}

// colored shadow
private fun Modifier.coloredShadow(
    color: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 20.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
) = this.drawBehind {

    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparent = color.copy(alpha = 0f).toArgb()

    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparent

        frameworkPaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            left = 10f,
            top = 0f,
            right = this.size.width - 10,
            bottom = this.size.height,
            radiusX = borderRadius.toPx(),
            radiusY = borderRadius.toPx(),
            paint = paint

        )
    }
}