package com.relly.app.presentation.viewmodel.auth

import com.relly.app.domain.model.User

sealed class LoginState {
    data object Idle : LoginState()
    data object Loading : LoginState()
    data class Success(val user: User) : LoginState()
    data class Error(val message: String) : LoginState()
}
