package com.relly.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.relly.app.data.local.AuthManager
import com.relly.app.presentation.navigation.AppNavHost
import com.relly.app.ui.theme.RellyAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var authManager: AuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RellyAppTheme {
                val navController = rememberNavController()
                AppNavHost(
                    navController = navController,
                    authManager = authManager
                )
            }
        }
    }
}
