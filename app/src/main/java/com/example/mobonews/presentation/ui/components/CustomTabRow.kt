package com.example.mobonews.presentation.ui.components


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobonews.presentation.theme.White


@Composable
fun CustomTabRow(
    modifier: Modifier = Modifier,
    tabState: TabState,
    onTabClick: (index: Int) -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        backgroundColor = MaterialTheme.colors.surface,
        shape = MaterialTheme.shapes.medium,
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize().padding(4.dp)) {
            val inductorWidth = maxWidth / 2f
            val inductorXAnim by animateDpAsState(
                targetValue = if (tabState == TabState.Recommended) 0.dp else inductorWidth,
                animationSpec = tween(
                    durationMillis = 250,
                    easing = LinearEasing,
                )
            )
            val recommendedColor by animateColorAsState(
                targetValue = if (tabState == TabState.Recommended)
                    MaterialTheme.colors.White else MaterialTheme.colors.secondary,
                animationSpec = tween(
                    durationMillis = 250,
                    easing = LinearEasing,
                )
            )
            val flowingColor by animateColorAsState(
                targetValue = if (tabState == TabState.Flowing)
                    MaterialTheme.colors.White else MaterialTheme.colors.secondary,
                animationSpec = tween(
                    durationMillis = 250,
                    easing = LinearEasing,
                )
            )
            // inductor
            Card(
                modifier = Modifier
                    .width(inductorWidth)
                    .fillMaxHeight()
                    .offset(
                        x = inductorXAnim, // update inductor x offset
                        y = 0.dp,
                    ),
                backgroundColor = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.medium,
            ) {}
            // titles
            Row(
                modifier = Modifier.fillMaxSize(),
            ) {
                // recommended
                TextButton(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.weight(0.5f).fillMaxHeight(),
                    onClick = {
                        onTabClick(0)
                    }) {
                    Text(
                        text = "پیشنهادی",
                        color = recommendedColor,
                        style = MaterialTheme.typography.h2,
                    )
                }
                // flowing
                TextButton(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.weight(0.5f).fillMaxHeight(),
                    onClick = {
                        onTabClick(1)
                    }) {
                    Text(
                        text = "دنبال میکنید",
                        color = flowingColor,
                        style = MaterialTheme.typography.h2,
                    )
                }
            }
        }
    }
}

enum class TabState {
    Recommended,
    Flowing,
}




