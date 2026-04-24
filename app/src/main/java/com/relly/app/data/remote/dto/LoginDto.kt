package com.relly.app.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginDto(
    val email: String,
    val password: String,
)
