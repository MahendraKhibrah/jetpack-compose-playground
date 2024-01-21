package com.example.firstappplayground.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.firstappplayground.Greeting
import com.example.firstappplayground.getName
import com.example.firstappplayground.common.navigation.NavigationItem
import com.example.firstappplayground.presentation.viewModel.ProfileViewModel

@Composable
fun FirstPage(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel<ProfileViewModel>()
){
    val state = viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) {
        viewModel.getProfile()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(text = "this is first page")
            for (name in getName()) {
                Greeting(name)
            }
            Greeting(name = "tes")
            Button(onClick = {
                navController.navigate(NavigationItem.Detail.withArgs("tes", "tes@tes.com"))
            }) {
                Text(text = "navigate to second page")
            }
        }
    )
}