package com.jackl.jackprojects.naivenetwork.auth.presentation.register

sealed interface RegisterAction {
    data object OnLoginClick: RegisterAction
    data object OnSignUpClick: RegisterAction
    data object OnToggleClick: RegisterAction
}