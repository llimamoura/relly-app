package com.relly.app.data.local

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class AuthManager (context: Context) {

    private val prefs = EncryptedSharedPreferences.create(
        context,
        "relly_auth_prefs",
        MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveToken(token: String) = prefs.edit().putString("access_token", token).apply()
    fun getToken(): String? = prefs.getString("access_token", null)

    fun saveRefreshToken(token: String) = prefs.edit().putString("refresh_token", token).apply()
    fun getRefreshToken(): String? = prefs.getString("refresh_token", null)

    fun isLoggedIn(): Boolean = getToken() != null

    fun clearAll() = prefs.edit().clear().apply()
}