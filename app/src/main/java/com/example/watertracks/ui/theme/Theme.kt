package com.example.watertracks.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = BluePrimary,
    onPrimary = BlueOnPrimary,
    primaryContainer = BluePrimaryContainer,
    secondary = BlueSecondary,
    background = BlueBackground,
    surface = BlueSurface,
    surfaceVariant = BlueSurfaceVariant,
    onSurfaceVariant = BlueOnSurfaceVariant
)

private val DarkColors = darkColorScheme(
    primary = BluePrimaryDark,
    onPrimary = BlueOnPrimaryDark,
    primaryContainer = BluePrimaryContainerDark,
    secondary = BlueSecondaryDark,
    background = BlueBackgroundDark,
    surface = BlueSurfaceDark,
    surfaceVariant = BlueSurfaceVariantDark,
    onSurfaceVariant = BlueOnSurfaceVariantDark
)

@Composable
fun WaterTracksTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic colour is off by default so the clean blue identity is always used.
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
