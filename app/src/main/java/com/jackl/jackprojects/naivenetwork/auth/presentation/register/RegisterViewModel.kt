package com.jackl.jackprojects.naivenetwork.auth.presentation.register

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel: ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()

    fun onAction(action: RegisterAction) {
        when(action) {
            RegisterAction.OnSignUpClick -> TODO()
            RegisterAction.OnToggleClick -> {
                _state.update {
                    it.copy(isToggleVisible = !_state.value.isToggleVisible)
                }
            }
            else -> Unit
        }
    }
}