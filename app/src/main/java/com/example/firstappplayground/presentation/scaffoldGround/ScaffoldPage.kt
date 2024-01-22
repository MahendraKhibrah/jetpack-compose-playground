package com.example.firstappplayground.presentation.scaffoldGround

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.example.firstappplayground.common.navigation.MainPageNavHost
import com.example.firstappplayground.common.navigation.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldPage() {
    val navigation = rememberNavController()
    val navItems = listOf(
        BottomNavItem(
            route = NavigationItem.Home.route,
            title = "Home"
        ),
        BottomNavItem(
            route = NavigationItem.Setting.route,
            title = "Setting"
        ),
        BottomNavItem(
            route = NavigationItem.Profile.route,
            title = "Profile"
        ),
    )

    var currentRoute by rememberSaveable {
        mutableStateOf("home")
    }

    Scaffold(
        bottomBar = {
                    NavigationBar {
                        navItems.forEach { item ->
                            NavigationBarItem(
                                selected = currentRoute == item.route,
                                onClick = {
                                    currentRoute = item.route
                                    navigation.navigate(item.route)
                                },
                                icon = {
                                     Icon(
                                         painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
                                         contentDescription = null
                                     )
                                },
                            )
                        }
                    }
        },
    ) { innerPadding ->
        MainPageNavHost(navController = navigation, modifier = Modifier.padding(innerPadding))
    }
}

data class BottomNavItem(
    val route: String,
    val title: String
)

