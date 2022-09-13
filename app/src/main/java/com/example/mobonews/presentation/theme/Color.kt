package com.example.mobonews.presentation.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val red = Color(0xFFFF033E)
val black700 = Color(0xFF1C1F2E)
val lightRed = Color(0xFFFFCDD8)
val gray = Color(0xFFBFC3C8)
val white700 = Color(0xFFFAFAFA)
val white = Color(0xFFFFFFFF)
val black = Color(0xFF000000)

val Colors.white: Color
    @Composable
    get() = if (isLight) Color.White else Color.White

val Colors.black: Color
    @Composable
    get() = if (isLight) Color.Black else Color.Black

