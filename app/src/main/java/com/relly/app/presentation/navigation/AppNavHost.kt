package com.relly.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.relly.app.data.local.AuthManager
import com.relly.app.presentation.screens.auth.LoginScreen
import com.relly.app.presentation.screens.auth.RegisterScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    authManager: AuthManager,
) {
    val isLoggedIn by authManager.isLoggedInFlow.collectAsStateWithLifecycle()

    LaunchedEffect(isLoggedIn) {
        if (!isLoggedIn) {
            navController.navigate("auth_graph") {
                popUpTo(0) { inclusive = true }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) "main_graph" else "auth_graph"
    ) {
        navigation(
            startDestination = Screen.Login.route,
            route = "auth_graph"
        ) {
            composable(Screen.Login.route) {
                LoginScreen(navController)
            }
            composable(Screen.Register.route) {
                RegisterScreen(navController)
            }
        }

        composable("main_graph") {
            MainScreen()
        }
    }
}
