package com.jackl.jackprojects.naivenetwork.auth.presentation.login

import com.jackl.jackprojects.naivenetwork.core.presentation.ui.util.UiText

sealed interface LoginEvent {
    data object Success: LoginEvent
    data class Error(val error: UiText): LoginEvent
}