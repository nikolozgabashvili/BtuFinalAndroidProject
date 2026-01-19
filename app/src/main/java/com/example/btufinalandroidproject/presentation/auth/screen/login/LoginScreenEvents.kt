package com.example.btufinalandroidproject.presentation.auth.screen.login

import com.example.btufinalandroidproject.domain.auth.util.FirebaseError

sealed interface LoginScreenEvents {
    data object NavigateHome : LoginScreenEvents
    data class InvalidInputs(val passwordValid: Boolean, val emailValid: Boolean) :
        LoginScreenEvents

    data class Error(val firebaseError: FirebaseError) : LoginScreenEvents
}