package com.example.godsviking.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.godsviking.R

val Viking = FontFamily(
    Font(R.font.viking_n)
)

val Cincel = FontFamily(
    Font(R.font.cinzel_bold)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Cincel,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Cincel,
        fontSize = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Cincel,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Cincel,
        fontSize = 14.sp
    )
)