package com.jackl.jackprojects.naivenetwork.auth.presentation.login

sealed interface LoginAction {
    data class OnEmailTyped(val email: String): LoginAction
    data class OnPasswordTyped(val password: String): LoginAction
    data object OnToggleClicked: LoginAction
    data object OnLoginClicked: LoginAction
    data object OnSignUpClicked: LoginAction
}