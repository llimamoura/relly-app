package com.relly.app.data.remote.api

import com.relly.app.data.remote.dto.LoginDto
import com.relly.app.data.remote.dto.RegisterDto
import com.relly.app.data.remote.dto.auth.AuthResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("auth/register")
    suspend fun register(
        @Body dto: RegisterDto
    ): AuthResponseDto

    @POST("auth/login")
    suspend fun login(
        @Body dto: LoginDto
    ): AuthResponseDto

    @POST("auth/logout")
    suspend fun logout()
}
