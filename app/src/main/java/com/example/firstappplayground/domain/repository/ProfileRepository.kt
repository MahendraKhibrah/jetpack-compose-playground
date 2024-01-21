package com.example.firstappplayground.domain.repository

import com.example.firstappplayground.common.utils.Resource
import com.example.firstappplayground.domain.model.User

interface ProfileRepository {
    suspend fun getProfile(): Resource<User>
}