package com.example.btufinalandroidproject.domain.core.validation

interface UserDataValidator {
    fun isEmailValid(email: String): Boolean
    fun validatePassword(password: String): PasswordValidationState
}