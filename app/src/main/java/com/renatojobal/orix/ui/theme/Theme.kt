package com.renatojobal.orix.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val LightColorPalette = lightColors(
    primary = White,
    primaryVariant = JavaGreen,
    secondary = Black,


    background = White,
    surface = White,
    onPrimary = Black,
    onSecondary = White,
    onBackground = Black,
    onSurface = Black,

)

@Composable
fun OrixTheme(content: @Composable() () -> Unit) {
    val colors =  LightColorPalette


    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}