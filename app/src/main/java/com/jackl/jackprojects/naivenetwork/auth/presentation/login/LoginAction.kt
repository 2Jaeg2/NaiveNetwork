package com.jackl.jackprojects.naivenetwork.auth.presentation.login

sealed interface LoginAction {
    data object OnToggleClicked: LoginAction
    data object OnLoginClicked: LoginAction
    data object OnSignUpClicked: LoginAction
}