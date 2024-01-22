package com.example.firstappplayground.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.firstappplayground.presentation.scaffoldGround.HomePage
import com.example.firstappplayground.presentation.scaffoldGround.ProfilePage
import com.example.firstappplayground.presentation.scaffoldGround.SettingPage

@Composable
fun MainPageNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
) {
    NavHost(navController = navController, startDestination = startDestination){
        composable(NavigationItem.Home.route){ HomePage() }
        composable(NavigationItem.Setting.route){ SettingPage() }
        composable(NavigationItem.Profile.route){ ProfilePage() }
    }
}