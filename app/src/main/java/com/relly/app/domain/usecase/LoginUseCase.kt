package com.relly.app.domain.usecase

import com.relly.app.domain.model.User
import com.relly.app.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(email: String, password: String): Result<User> {
        if (email.isBlank()) return Result.failure(Exception("Email obrigatório"))
        if (password.isBlank()) return Result.failure(Exception("Senha obrigatória"))
        return authRepository.login(email, password)
    }
}