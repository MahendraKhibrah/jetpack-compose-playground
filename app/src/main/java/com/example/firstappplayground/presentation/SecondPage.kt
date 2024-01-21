package com.example.firstappplayground.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.firstappplayground.Greeting
import com.example.firstappplayground.getName

@Composable
fun SecondPage(name : String, email : String){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(text = "this is second page, you are $name and $email")
            for (name in getName()) {
                Greeting(name)
            }
            Greeting(name = "tes")
        }
    )
}