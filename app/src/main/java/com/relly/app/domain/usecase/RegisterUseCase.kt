package com.relly.app.domain.usecase

import com.relly.app.domain.model.User
import com.relly.app.domain.repository.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(name: String, email: String, password: String): Result<User> {
        if (name.isBlank()) return Result.failure(Exception("Nome obrigatório"))
        if (email.isBlank()) return Result.failure(Exception("Email obrigatório"))
        if (password.length < 6) return Result.failure(Exception("Senha deve ter pelo menos 6 caracteres"))
        return authRepository.register(name, email, password)
    }
}
