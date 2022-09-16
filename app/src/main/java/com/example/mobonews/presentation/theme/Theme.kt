package com.example.mobonews.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = red,
    primaryVariant = black700,
    secondary = gray,
    background = white700,
    surface = white,
    onPrimary = lightRed,
)

private val LightColorPalette = lightColors(
    primary = red,
    primaryVariant = black700,
    secondary = gray,
    background = white700,
    surface = white,
    onPrimary = lightRed,
)

@Composable
fun MoboNewsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}