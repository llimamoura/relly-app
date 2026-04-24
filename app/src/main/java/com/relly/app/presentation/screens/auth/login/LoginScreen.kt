package com.relly.app.presentation.screens.auth.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.relly.app.presentation.navigation.Screen
import com.relly.app.presentation.viewModel.auth.LoginState
import com.relly.app.presentation.viewModel.auth.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val loginState = viewModel.loginState.collectAsState()
    val state = loginState.value

    when (state) {
        is LoginState.Idle -> LoginForm(
            onLogin = { email, password -> viewModel.login(email, password) },
            onNavigateToRegister = { navController.navigate(Screen.Register.route) },
        )
        is LoginState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
        is LoginState.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(Screen.MainGraph.route) {
                    popUpTo(Screen.AuthGraph.route) { inclusive = true }
                    launchSingleTop = true
                }
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
        }
        is LoginState.Error -> LoginForm(
            onLogin = { email, password -> viewModel.login(email, password) },
            onNavigateToRegister = { navController.navigate(Screen.Register.route) },
            errorMessage = state.message,
        )
    }
}
