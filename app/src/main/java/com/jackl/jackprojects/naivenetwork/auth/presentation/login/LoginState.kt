package com.jackl.jackprojects.naivenetwork.auth.presentation.login

import androidx.compose.foundation.text.input.TextFieldState

data class LoginState(
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val isLoggin: Boolean = false,
    val isToggleVisible: Boolean= false
)
