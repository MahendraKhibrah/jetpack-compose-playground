package com.example.firstappplayground.presentation.state

import com.example.firstappplayground.domain.model.User

data class ProfileState(
    val data : User? = null,
    val isLoading : Boolean = false,
    val isError : Boolean = false,
)
