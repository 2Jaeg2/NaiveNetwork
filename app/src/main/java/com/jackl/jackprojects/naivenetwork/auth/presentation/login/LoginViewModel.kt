package com.jackl.jackprojects.naivenetwork.auth.presentation.login

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onAction(action: LoginAction) {
        when(action) {
            LoginAction.OnLoginClicked -> TODO()
            LoginAction.OnToggleClicked -> {
                _state.update {
                    it.copy(isToggleVisible = !state.value.isToggleVisible)
                }
            }
            else -> Unit
        }
    }
}