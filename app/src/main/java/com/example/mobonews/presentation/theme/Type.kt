package com.example.mobonews.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mobonews.R

// Fonts
private val SHABNAM_BOLD = FontFamily(
    Font(R.font.shabnam_bold, FontWeight.Normal)
)
private val SHABNAM_MEDIUM = FontFamily(
    Font(R.font.shabnam_medium, FontWeight.Normal)
)
private val SHABNAM_LIGHT = FontFamily(
    Font(R.font.shabnam_light, FontWeight.Normal)
)

// Material typography
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    ),
    h2 = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    h3 = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    h4 = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    h5 = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
    ),
    h6 = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
    ),
    button = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    body1 = TextStyle(
        fontFamily = SHABNAM_MEDIUM,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    body2 = TextStyle(
        fontFamily = SHABNAM_LIGHT,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
    ),
)

//val Typography.title: TextStyle
//    @Composable
//    get() = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//    )