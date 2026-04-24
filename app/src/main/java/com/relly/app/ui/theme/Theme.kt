package com.relly.app.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary             = Teal500,
    onPrimary           = Color.White,
    primaryContainer    = Teal100,
    onPrimaryContainer  = Teal900,

    secondary           = Navy500,
    onSecondary         = Color.White,
    secondaryContainer  = Navy50,
    onSecondaryContainer = Navy900,

    tertiary            = Green500,
    onTertiary          = Color.White,
    tertiaryContainer   = Teal50,
    onTertiaryContainer = Teal900,

    error               = ErrorLight,
    onError             = OnErrorLight,
    errorContainer      = ErrorContainerLight,
    onErrorContainer    = OnErrorContainerLight,

    background          = Grey50,
    onBackground        = Navy900,
    surface             = Color.White,
    onSurface           = Navy900,
    surfaceVariant      = Grey200,
    onSurfaceVariant    = Navy400,

    outline             = Grey600,
    outlineVariant      = Grey300,
    inverseSurface      = Navy800,
    inverseOnSurface    = Grey50,
    inversePrimary      = Teal200,
    scrim               = Color.Black,
)

private val DarkColorScheme = darkColorScheme(
    primary             = Teal200,
    onPrimary           = Teal800,
    primaryContainer    = Teal700,
    onPrimaryContainer  = Teal100,

    secondary           = Grey300,
    onSecondary         = Navy700,
    secondaryContainer  = Navy600,
    onSecondaryContainer = Grey100,

    tertiary            = Green500,
    onTertiary          = Teal900,
    tertiaryContainer   = Teal600,
    onTertiaryContainer = Teal100,

    error               = ErrorDark,
    onError             = OnErrorDark,
    errorContainer      = ErrorContainerDark,
    onErrorContainer    = OnErrorContainerDark,

    background          = Navy900,
    onBackground        = Grey50,
    surface             = Navy800,
    onSurface           = Grey100,
    surfaceVariant      = Navy600,
    onSurfaceVariant    = Grey500,

    outline             = Grey700,
    outlineVariant      = Navy500,
    inverseSurface      = Grey100,
    inverseOnSurface    = Navy900,
    inversePrimary      = Teal500,
    scrim               = Color.Black,
)

@Composable
fun RellyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = RellyTypography,
        content     = content,
    )
}
