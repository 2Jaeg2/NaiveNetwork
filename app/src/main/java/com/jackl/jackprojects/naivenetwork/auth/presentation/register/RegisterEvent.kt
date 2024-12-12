package com.jackl.jackprojects.naivenetwork.auth.presentation.register

import com.jackl.jackprojects.naivenetwork.core.presentation.ui.util.UiText

sealed interface RegisterEvent {
    data object Success: RegisterEvent
    data class Error(val error: UiText): RegisterEvent
}