package com.example.firstappplayground.common.navigation


sealed class NavigationItem(val route: String){
    object Main: NavigationItem("main")
    object Detail: NavigationItem("detail")

    fun withArgs(vararg args: Any?): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}