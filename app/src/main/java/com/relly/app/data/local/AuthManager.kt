package com.relly.app.data.local

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthManager(context: Context) {

    private val prefs = EncryptedSharedPreferences.create(
        context,
        "relly_auth_prefs",
        MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    private val _isLoggedIn = MutableStateFlow(getToken() != null)
    val isLoggedInFlow: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    fun saveToken(token: String) {
        prefs.edit().putString("access_token", token).apply()
        _isLoggedIn.value = true
    }

    fun getToken(): String? = prefs.getString("access_token", null)

    fun saveRefreshToken(token: String) = prefs.edit().putString("refresh_token", token).apply()
    fun getRefreshToken(): String? = prefs.getString("refresh_token", null)

    fun saveUserId(userId: String) = prefs.edit().putString("user_id", userId).apply()
    fun getUserId(): String? = prefs.getString("user_id", null)

    fun isLoggedIn(): Boolean = getToken() != null

    fun clearAll() {
        prefs.edit().clear().apply()
        _isLoggedIn.value = false
    }
}
