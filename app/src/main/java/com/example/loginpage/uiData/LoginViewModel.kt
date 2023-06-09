package com.example.loginpage.uiData

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

// Login ViewModel
class LoginViewModel : ViewModel() {

    data class LoginPageUiState(val userName: String = "")

    private val _uiState = MutableStateFlow(LoginPageUiState())

    val uiState = _uiState.asStateFlow()


    var userName by mutableStateOf("")

    fun onUserNameChanged(word: String) {
        userName = word
    }


}