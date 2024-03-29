package com.example.firstappplayground.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.firstappplayground.presentation.FirstPage
import com.example.firstappplayground.presentation.SecondPage
import com.example.firstappplayground.presentation.scaffoldGround.ScaffoldPage

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Master.route,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavigationItem.Master.route) { FirstPage(navController) }
        composable(
            route = NavigationItem.Detail.route + "/{name}/{email}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "tes"
                },
                navArgument("email") {
                    type = NavType.StringType
                    defaultValue = "tes@tes.tes"
                }
            )
        ) {
            SecondPage(
                name = it.arguments?.getString("name") ?: "tes",
                email = it.arguments?.getString("email") ?: "tes@res.tes"
            )
        }
        composable(NavigationItem.Main.route) { ScaffoldPage() }
    }
}