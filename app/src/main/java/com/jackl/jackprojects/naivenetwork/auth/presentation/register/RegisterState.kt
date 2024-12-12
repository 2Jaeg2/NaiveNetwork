package com.jackl.jackprojects.naivenetwork.auth.presentation.register

import androidx.compose.foundation.text.input.TextFieldState

data class RegisterState(
    val username: TextFieldState = TextFieldState(),
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val isLoading: Boolean = false,
    val isToggleVisible: Boolean = false
)
