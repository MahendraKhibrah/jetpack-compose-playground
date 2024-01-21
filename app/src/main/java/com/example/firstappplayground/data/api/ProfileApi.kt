package com.example.firstappplayground.data.api

import com.example.firstappplayground.common.Env
import com.example.firstappplayground.data.ProfileDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Url

interface ProfileApi {

    @GET("/{name}")
    suspend fun getProfile(
        @Header("X-Api-Key") apiKey: String = Env().apiKey,
        @Path("name") name: String
    ): Response<ProfileDto>
}