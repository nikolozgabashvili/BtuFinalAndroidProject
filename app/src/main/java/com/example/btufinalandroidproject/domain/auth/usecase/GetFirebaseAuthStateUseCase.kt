package com.example.btufinalandroidproject.domain.auth.usecase

import com.example.btufinalandroidproject.domain.auth.repository.AuthRepository
import javax.inject.Inject

class GetFirebaseAuthStateUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke() = repository.getFirebaseAuthState()
}