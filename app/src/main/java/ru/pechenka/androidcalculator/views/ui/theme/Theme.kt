package ru.pechenka.androidcalculator.views.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable


private val LightColorScheme = lightColorScheme(
    background = LightBackgroundColor,

    primary = LightDisplayColor,
    onPrimary = LightDisplayBorderColor,

    secondary = LightButtonColor,
    onSecondary = LightButtonBorderColor,

    onSurface = LightTextColor
)

private val DarkColorScheme = darkColorScheme(
    background = DarkBackgroundColor,

    primary = DarkDisplayColor,
    onPrimary = DarkDisplayBorderColor,

    secondary = DarkButtonColor,
    onSecondary = DarkButtonBorderColor,

    onSurface = DarkTextColor
)

@Composable
fun AndroidCalculatorTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}