package com.example.btufinalandroidproject.presentation.auth.screen.register

import com.example.btufinalandroidproject.domain.auth.util.FirebaseError

sealed interface RegisterScreenEvents {
    data object Success : RegisterScreenEvents
    data class InvalidInputs(
        val emailValid: Boolean,
        val passwordValid: Boolean,
        val repeatPasswordValid: Boolean
    ) : RegisterScreenEvents

    data class Error(val firebaseError: FirebaseError) : RegisterScreenEvents

}