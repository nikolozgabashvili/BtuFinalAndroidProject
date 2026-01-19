package com.example.btufinalandroidproject.domain.auth.usecase

import com.example.btufinalandroidproject.domain.auth.repository.AuthRepository
import javax.inject.Inject

class GetUserEmailUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke() = authRepository.getUserEmail()
}