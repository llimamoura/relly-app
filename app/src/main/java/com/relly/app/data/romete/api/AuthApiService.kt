package com.relly.app.data.romete.api

import com.relly.app.data.romete.dto.LoginDto
import com.relly.app.data.romete.dto.RegisterDto
import com.relly.app.data.romete.dto.auth.AuthResponseDto
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