package com.relly.app.data.remote.dto.auth

import com.relly.app.domain.model.User
import com.relly.app.domain.model.UserPlan
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthResponseDto(
    @Json(name = "access_token") val accessToken: String,
    @Json(name = "refresh_token") val refreshToken: String,
    val user: UserDto,
)

@JsonClass(generateAdapter = true)
data class UserDto(
    val id: String,
    val name: String,
    val email: String,
    val plan: String,
    @Json(name = "trial_ends_at") val trialEndsAt: String?,
)

fun AuthResponseDto.toUser(): User = User(
    id = user.id,
    name = user.name,
    email = user.email,
    plan = runCatching { UserPlan.valueOf(user.plan.uppercase()) }.getOrDefault(UserPlan.TRIAL),
    trialEndsAt = user.trialEndsAt,
)
