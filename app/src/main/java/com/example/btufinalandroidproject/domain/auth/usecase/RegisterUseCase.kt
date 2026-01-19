package com.example.btufinalandroidproject.domain.auth.usecase

import com.example.btufinalandroidproject.domain.auth.repository.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String) =
        authRepository.register(email, password)
}