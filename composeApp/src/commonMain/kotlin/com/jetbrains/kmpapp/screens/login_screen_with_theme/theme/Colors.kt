package com.jetbrains.kmpapp.screens.login_screen_with_theme.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class CustomTheme(
    val surface: Color,
    val surfaceLight: Color,
    val textPrimary: Color,
    val textInverse: Color,
    val iconPrimary: Color,
    val iconInverse: Color,
    val borderFocused: Color,
    val borderPrimary: Color,
    val borderError: Color,
    val buttonPrimary: Color,
    val buttonDisabled: Color,
)

val lightThemeColors = CustomTheme(
    surface = Color(0xFFFFFFFF),
    surfaceLight = Color(0xFFFAFAFA),
    textPrimary = Color.Black,
    textInverse = Color.White,
    iconPrimary = Color.Black,
    iconInverse = Color.White,
    borderFocused = Color.Black,
    borderPrimary = Color(0xFFEBEBEB),
    borderError = Color(0xFFC53638),
    buttonPrimary = Color(0xFFDC6B0F),
    buttonDisabled = Color(0xFFDDDDDD),
)

val darkThemeColors = CustomTheme(
    surface = Color(0xFF000000),
    surfaceLight = Color(0xFF232323),
    textPrimary = Color.White,
    textInverse = Color.Black,
    iconPrimary = Color.White,
    iconInverse = Color.Black,
    borderFocused = Color.White,
    borderPrimary = Color(0xFF4D4D4D),
    borderError = Color(0xFFFF6E70),
    buttonPrimary = Color(0xFFFFAE6C),
    buttonDisabled = Color(0xFF454545),
)

val LocalTheme = staticCompositionLocalOf<CustomTheme> {
    error("No colors provided.")
}