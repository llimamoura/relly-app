package com.relly.app.domain.repository

import com.relly.app.domain.model.User
import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {
    val isLoggedInFlow: StateFlow<Boolean>
    suspend fun login(email: String, password: String): Result<User>
    suspend fun register(name: String, email: String, password: String): Result<User>
    suspend fun logout()
    fun isLoggedIn(): Boolean
}
