package com.example.firstappplayground.domain.model

class User (name: String?, email: String?) {
    private var name: String
    private var email: String

    init {
        this.name = name ?: ""
        this.email = email ?: ""
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String {
        return name
    }

    fun setEmail(age: String) {
        this.email = email
    }

    fun getEmail(): String {
        return email
    }
}