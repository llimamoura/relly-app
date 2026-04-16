package com.relly.app.domain.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val plan: UserPlan,
    val trialEndsAt: String?
)

enum class UserPlan {
    TRIAL,
    PREMIUM
}