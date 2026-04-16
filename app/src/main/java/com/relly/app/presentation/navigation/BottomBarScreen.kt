package com.relly.app.presentation.navigation

data class BottomBarItem(
    val route: String,
    val label: String,
    val iconText: String,
)

object BottomBarScreen {
    val items = listOf(
        BottomBarItem(
            route = Screen.Home.route,
            label = "Home",
            iconText = "H"
        )
    )
}
