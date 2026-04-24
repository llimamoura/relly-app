package com.relly.app.domain.repository

import com.relly.app.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<User>
    suspend fun register(name: String, email: String, password: String): Result<User>
    suspend fun logout()
    fun isLoggedIn(): Boolean
}