package com.relly.app.data.repository

import com.relly.app.data.local.AuthManager
import com.relly.app.data.romete.api.AuthApiService
import com.relly.app.data.romete.dto.LoginDto
import com.relly.app.data.romete.dto.RegisterDto
import com.relly.app.data.romete.dto.auth.toUser
import com.relly.app.domain.model.User
import com.relly.app.domain.repository.AuthRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApiService: AuthApiService,
    private val authManager: AuthManager
) : AuthRepository {

    override suspend fun login(email: String, password: String): Result<User> {
        return try {
            val response = authApiService.login(LoginDto(email, password))
            authManager.saveToken(response.accessToken)
            authManager.saveRefreshToken(response.refreshToken)
            authManager.saveUserId(response.user.id)
            Result.success(response.toUser())
        } catch (e: HttpException) {
            when (e.code()) {
                401 -> Result.failure(Exception("Email ou senha incorretos"))
                422 -> Result.failure(Exception("Dados inválidos"))
                else -> Result.failure(Exception("Erro ao fazer login. Tente novamente"))
            }
        } catch (e: IOException) {
            Result.failure(Exception("Sem conexão com a internet"))
        } catch (e: Exception) {
            Result.failure(Exception("Erro inesperado. Tente novamente"))
        }
    }

    override suspend fun register(
        name: String,
        email: String,
        password: String
    ): Result<User> {
        return try {
            val response = authApiService.register(RegisterDto(name, email, password))
            authManager.saveToken(response.accessToken)
            authManager.saveRefreshToken(response.refreshToken)
            authManager.saveUserId(response.user.id)
            Result.success(response.toUser())
        } catch (e: HttpException) {
            when (e.code()) {
                409 -> Result.failure(Exception("Email já cadastrado"))
                422 -> Result.failure(Exception("Dados inválidos"))
                else -> Result.failure(Exception("Erro ao criar conta. Tente novamente"))
            }
        } catch (e: IOException) {
            Result.failure(Exception("Sem conexão com a internet"))
        } catch (e: Exception) {
            Result.failure(Exception("Erro inesperado. Tente novamente"))
        }
    }

    override suspend fun logout() {
        try {
            authApiService.logout()
        } finally {
            authManager.clearAll()
        }
    }

    override fun isLoggedIn(): Boolean = authManager.isLoggedIn()
}
