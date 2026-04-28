package com.relly.app.presentation.viewmodel.auth

import com.relly.app.domain.model.User

sealed class RegisterState {
    data object Idle : RegisterState()
    data object Loading : RegisterState()
    data class Success(val user: User) : RegisterState()
    data class Error(val message: String) : RegisterState()
}
