package com.example.mobonews.presentation.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.*
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
import com.example.mobonews.presentation.navigation.bottomNavigation.MainBNScreens


@Composable
fun BottomNavigation(
    navController: NavHostController,
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
            MainBNScreens.Home,
            MainBNScreens.Discover,
            MainBNScreens.AddNew,
            MainBNScreens.Save,
            MainBNScreens.Profile,
        )
        Content(
            navController,
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
    items: List<MainBNScreens>,
    cardHeight: Int,
    cardWidth: Int,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val cardXPointState = remember { mutableStateOf(tabsPoint[0].dp) }

    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.White
    ) {
        for (index in items.indices) {
            BottomNavigationItem(
                icon = {
                    if(currentRoute == items[index].screen_route){
                        Image(painterResource(id = items[index].enabledIcon),
                            contentDescription = null)
                    }else{
                        Icon(painterResource(id = items[index].icon),
                            contentDescription = null)
                    }
                },
                selectedContentColor = Color(0xFFFF033E),
                unselectedContentColor = Color(0xFFBFC3C8),
                selected = currentRoute == items[index].screen_route,
                onClick = {
                    cardXPointState.value = tabsPoint[index].dp
                    navController.navigate(items[index].screen_route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }

    SelectorUI(cardWidth = cardWidth, cardHeight, cardXPointState)

}

@Composable
private fun SelectorUI(cardWidth: Int, cardHeight: Int, cardXPointState: MutableState<Dp>) {
    val cardXAnim by animateDpAsState(
        targetValue = cardXPointState.value,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        )
    )
    Card(
        modifier = Modifier.size(width = cardWidth.dp, height = cardHeight.dp)
            .offset(x = cardXAnim)
            .coloredShadow(
                color = Color(0xFFFF033E),
                alpha = 0.6f,
                borderRadius = 0.dp,
                shadowRadius = 20.dp,
                offsetY = 10.dp,
                offsetX = 0.dp,
            ),
        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
        backgroundColor = Color(0x99FF033E),

        ) {}
}

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