package com.relly.app.presentation.navigation

sealed class Screen (val route: String) {

    object AuthGraph : Screen("auth_graph")
    object MainGraph : Screen("main_graph")


    object Login : Screen("login")
    object Register : Screen("register")

    object Home : Screen("home")
    object Summary : Screen("summary")
    object Profile : Screen("profile")
    object Settings : Screen("settings")
}