package com.example.loginpage.uiData


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.loginpage.data.DataManager.users
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


// Login ViewModel
class LoginViewModel : ViewModel() {

    data class LoginPageUiState(val wrongUser: Boolean = false,
                                val currentUser: String = "",
                                val currentPassword: String = "")

    private val _uiState = MutableStateFlow(LoginPageUiState())

    val uiState = _uiState.asStateFlow()


    var userName by mutableStateOf("")

    var password by mutableStateOf("")

    // Function to update user name
    fun onUserNameChanged(word: String) {
        userName = word
    }

    // Function to update user password
    fun onPasswordChanged(word: String) {
        password = word
    }



    // Check if the there is a user already then check the password and update the wrongPassword field
    // in the dataState
    fun checkUserNameCredentials() {

        if (users.containsKey(userName)) {
            val user = users[userName]
            if (user?.password != password) {
                _uiState.update{ currentState ->
                    currentState.copy(wrongUser = true)
                }
            } else {
                _uiState.update{ currentState ->
                    currentState.copy(wrongUser = false)
                }
            }
        }
    }


}