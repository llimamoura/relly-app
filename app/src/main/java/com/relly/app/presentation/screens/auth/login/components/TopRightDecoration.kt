package com.relly.app.presentation.screens.auth.login.components

import androidx.compose.foundation.Canvas
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

@Composable
fun TopRightDecoration (
    modifier: Modifier = Modifier,
    primaryColor: Color = MaterialTheme.colorScheme.primary,
    secondaryColor: Color = MaterialTheme.colorScheme.secondary
) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height

        val lightPath = Path().apply {
            moveTo(w * 0.45f, 0f)
            lineTo(w, 0f)
            lineTo(w, h * 0.55f)
            close()
        }
        drawPath(lightPath, color = primaryColor)

        val darkPath = Path().apply {
            moveTo(w * 0.78f, 0f)
            lineTo(w, 0f)
            lineTo(w, h * 0.22f)
            close()
        }
        drawPath(darkPath, color = secondaryColor)
    }

}