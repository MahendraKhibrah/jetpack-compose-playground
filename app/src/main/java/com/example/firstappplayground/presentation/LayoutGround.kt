package com.example.firstappplayground.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun LayoutGround() {
    Column() {
        Box(
            modifier = Modifier
                .size(50.dp, 50.dp)
                .background(color = Color.Green)
        ) {

        }
        Box(
            modifier = Modifier
                .size(50.dp, 50.dp)
                .background(color = Color.Blue)
        ) {

        }
        Box(modifier = Modifier.background(color = Color.Red)) {
            Text(text = "Hello World", fontSize = 20.sp)
            Text(text = "Hello Indonesia", fontSize = 20.sp)
        }
        Box(modifier = Modifier
            .background(color = Color.Yellow)
            .size(100.dp, 100.dp)) {
            Box(modifier = Modifier
                .background(color = Color.Green)
                .size(50.dp, 50.dp)) {
                Column() {
                    Text(text = "Hello World", fontSize = 9.sp)
                    Text(text = "Hello Indonesia", fontSize = 9.sp)
                }
            }

        }
    }
}