package com.example.firstappplayground.data

import com.google.gson.annotations.SerializedName

data class ProfileDto(
    @SerializedName("name") val name: String?,
    @SerializedName("email") val email: String?
)
