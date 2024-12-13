package com.project.mindmap.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.project.mindmap.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

)

val outfitFontFamily = FontFamily(
    Font(R.font.outfit_regular),
    Font(R.font.outfit_bold),
    Font(R.font.outfit_thin),
    Font(R.font.outfit_semibold),
    Font(R.font.outfit_light),
    Font(R.font.outfit_medium),
    Font(R.font.outfit_extralight),
    Font(R.font.outfit_thin),
)

