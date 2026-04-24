package com.relly.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.relly.app.presentation.screens.auth.login.LoginScreen
import com.relly.app.presentation.screens.auth.register.RegisterScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    isLoggedIn: Boolean,
) {
    val startDestination = if (isLoggedIn) Screen.MainGraph.route else Screen.AuthGraph.route

    // Reage a mudanças pós-composição inicial (ex: logout)
    val isFirstRender = remember { mutableStateOf(true) }
    LaunchedEffect(isLoggedIn) {
        if (isFirstRender.value) {
            isFirstRender.value = false
            return@LaunchedEffect
        }
        navController.navigate(if (isLoggedIn) Screen.MainGraph.route else Screen.AuthGraph.route) {
            popUpTo(0) { inclusive = true }
            launchSingleTop = true
        }
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        navigation(
            startDestination = Screen.Login.route,
            route = Screen.AuthGraph.route,
        ) {
            composable(Screen.Login.route) {
                LoginScreen(navController)
            }
            composable(Screen.Register.route) {
                RegisterScreen(navController)
            }
        }

        navigation(
            startDestination = Screen.Home.route,
            route = Screen.MainGraph.route,
        ) {
            composable(Screen.Home.route) {
                MainScreen()
            }
        }
    }
}

