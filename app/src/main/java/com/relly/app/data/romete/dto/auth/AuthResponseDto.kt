package com.relly.app.data.romete.dto.auth

import com.relly.app.domain.model.User
import com.relly.app.domain.model.UserPlan
import com.squareup.moshi.Json

data class AuthResponseDto(
    @Json(name = "access_token")  val accessToken: String,
    @Json(name = "refresh_token") val refreshToken: String,
    val user: UserDto
)

data class UserDto(
    val id: String,
    val name: String,
    val email: String,
    val plan: UserPlan,
    @Json(name = "trial_ends_at") val trialEndsAt: String?
)

fun AuthResponseDto.toUser(): User = User(
    id = user.id,
    name = user.name,
    email = user.email,
    plan = user.plan,
    trialEndsAt = user.trialEndsAt
)