package com.relly.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.relly.app.presentation.navigation.AppNavHost
import com.relly.app.presentation.viewmodel.AppViewModel
import com.relly.app.ui.theme.RellyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RellyAppTheme {
                val appViewModel: AppViewModel = viewModel()
                val isLoggedIn by appViewModel.isLoggedInFlow.collectAsStateWithLifecycle()
                val navController = rememberNavController()
                AppNavHost(
                    navController = navController,
                    isLoggedIn = isLoggedIn,
                )
            }
        }
    }
}

