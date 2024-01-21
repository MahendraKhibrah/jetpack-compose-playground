package com.example.firstappplayground.domain.usecase

interface BaseUseCase<RES, REQ>{
    suspend fun execute(request: REQ): RES
}