package com.relly.app.presentation.screens.auth.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.relly.app.presentation.viewmodel.auth.LoginState
import com.relly.app.presentation.viewmodel.auth.RegisterState
import com.relly.app.presentation.viewmodel.auth.RegisterViewModel

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val state by viewModel.registerState.collectAsStateWithLifecycle()
    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val name by viewModel.name.collectAsStateWithLifecycle()

    when (state) {
        is RegisterState.Idle, is RegisterState.Error -> RegisterForm(
            email = email,
            password = password,
            name = name,
            onNameChange = viewModel::onNameChange,
            onEmailChange = viewModel::onEmailChange,
            onPasswordChange = viewModel::onPasswordChange,
            onRegister = viewModel::register,
        )
        is RegisterState.Loading, is RegisterState.Success -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
    }
}