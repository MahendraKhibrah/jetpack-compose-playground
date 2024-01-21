package com.example.firstappplayground.domain.usecase

import com.example.firstappplayground.common.utils.Resource
import com.example.firstappplayground.data.api.ProfileApi
import com.example.firstappplayground.domain.model.User
import com.example.firstappplayground.domain.repository.ProfileRepository
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val reps: ProfileRepository
) : BaseUseCase<Resource<User>, Int> {
    override suspend fun execute(request: Int): Resource<User> = reps.getProfile()
}