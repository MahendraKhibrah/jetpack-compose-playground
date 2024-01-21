package com.example.firstappplayground.data.repository

import android.util.Log
import com.example.firstappplayground.common.extension.tryParse
import com.example.firstappplayground.common.utils.Resource
import com.example.firstappplayground.data.api.ProfileApi
import com.example.firstappplayground.domain.model.User
import com.example.firstappplayground.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val api: ProfileApi
) : ProfileRepository {
    override suspend fun getProfile(): Resource<User> =
        try {
            api.getProfile(name = "randomuser").tryParse {
                val user = User(it?.name ?: "", it?.email ?: "")
                return Resource.Success(user)
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }

}