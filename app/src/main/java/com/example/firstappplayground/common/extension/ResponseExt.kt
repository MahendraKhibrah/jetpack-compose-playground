package com.example.firstappplayground.common.extension

import android.util.Log
import retrofit2.Response

inline fun <T, R> Response<T>.tryParse(parseBlock: (T?) -> R): R {
    return if (isSuccessful) {
        parseBlock(body())
    } else {
        throw RuntimeException("Unsuccessful response: ${code()}")
    }
}