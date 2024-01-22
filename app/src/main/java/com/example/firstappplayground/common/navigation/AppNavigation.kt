package com.example.firstappplayground.common.navigation


sealed class NavigationItem(val route: String){
    object Master: NavigationItem("master")
    object Detail: NavigationItem("detail")
    object Main : NavigationItem("main")
    object Setting : NavigationItem("setting")
    object Profile : NavigationItem("profile")
    object Home : NavigationItem("home")



    fun withArgs(vararg args: Any?): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}