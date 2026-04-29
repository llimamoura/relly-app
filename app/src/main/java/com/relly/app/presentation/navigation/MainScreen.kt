package com.relly.app.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.relly.app.presentation.screens.home.HomeScreen
import com.relly.app.presentation.screens.profile.ProfileScreen
import com.relly.app.presentation.screens.settings.SettingsScreen
import com.relly.app.presentation.screens.summary.SummaryScreen
import com.relly.app.ui.theme.Navy300
import com.relly.app.ui.theme.Teal50
import com.relly.app.ui.theme.Teal500
import com.relly.app.ui.theme.White

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        containerColor = Teal50,
        contentWindowInsets = WindowInsets(0),
        bottomBar = {
            NavigationBar (
                containerColor = Color.Transparent,
                windowInsets = WindowInsets(0),
                tonalElevation = 4.dp,
                modifier = Modifier
                    .padding(horizontal = 40.dp, vertical = 18.dp)
                    .height(75.dp)
                    .clip(RoundedCornerShape(200.dp))
                    .border(2.dp, White, RoundedCornerShape(200.dp))
                    .background(Teal50.copy(0.7f))
                    .padding(horizontal = 22.dp)
            ) {
                BottomBarScreen.items.forEach { screen ->
                    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                    NavigationBarItem(
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(if (selected) Teal500 else Color.Transparent),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = screen.icon,
                                    contentDescription = screen.label,
                                    tint = if (selected) White else MaterialTheme.colorScheme.primary,
                                )
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent,
                            selectedIconColor = White,
                            unselectedIconColor = Navy300,
                        ),
                        selected = selected,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Summary.route) {
                SummaryScreen(navController)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController)
            }
            composable(Screen.Settings.route) {
                SettingsScreen(navController)
            }
        }
    }
}
