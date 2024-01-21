package com.example.firstappplayground.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstappplayground.common.utils.Resource
import com.example.firstappplayground.domain.model.User
import com.example.firstappplayground.domain.usecase.GetProfileUseCase
import com.example.firstappplayground.presentation.state.ProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCase: GetProfileUseCase
) : ViewModel() {
    private var user: User = User("tes", "tes@tes.tes")

    fun setUser(name: String, email: String) {
        user.setName(name)
        user.setEmail(email)
    }

    fun getUser(): User {
        return user
    }

    private val _state = MutableStateFlow(ProfileState())
    val state = _state.asStateFlow()

    fun getProfile(){
        // ViewModel.launch
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            when (val result = useCase.execute(1)){
                is Resource.Success -> {
                    _state.update { it.copy(data = result.data) }
                }

                is Resource.Error -> {
                    _state.update { it.copy(isError = true) }
                }

                is Resource.Loading -> {
                    _state.update { it.copy(isLoading = true) }
                }
            }
            _state.update { it.copy(isLoading = false) }
        }

    }
}