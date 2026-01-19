package com.example.btufinalandroidproject.presentation.auth.screen.register

import com.example.btufinalandroidproject.domain.core.validation.PasswordValidationState

data class RegisterScreenState(
    val loading: Boolean = false,
    val passwordValidationState: PasswordValidationState = PasswordValidationState(),
    val password: String = "",
) {
    val showValidation: Boolean
        get() = password.isNotEmpty() && !passwordValidationState.isValid
}
