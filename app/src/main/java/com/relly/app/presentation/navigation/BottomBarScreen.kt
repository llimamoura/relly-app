package com.relly.app.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.composables.icons.lucide.ChartColumn
import com.composables.icons.lucide.ChartNoAxesColumn
import com.composables.icons.lucide.House
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Settings
import com.composables.icons.lucide.UserRound

data class BottomBarItem(
    val route: String,
    val label: String,
    val icon: ImageVector,
)

object BottomBarScreen {
    val items = listOf(
        BottomBarItem(
            route = Screen.Home.route,
            label = "Home",
            icon = Lucide.House,
        ),
        BottomBarItem(
          route = Screen.Summary.route,
            label = "Summary",
            icon = Lucide.ChartNoAxesColumn,
        ),
        BottomBarItem(
            route = Screen.Profile.route,
            label = "Profile",
            icon = Lucide.UserRound,
        ),
        BottomBarItem(
            route = Screen.Settings.route,
            label = "Settings",
            icon = Lucide.Settings,
        )
    )
}
