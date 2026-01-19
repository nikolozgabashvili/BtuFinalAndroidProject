package com.example.btufinalandroidproject.domain.auth.repository

import com.example.btufinalandroidproject.domain.auth.util.FirebaseError
import com.example.btufinalandroidproject.domain.core.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun isUserLoggedIn(): Boolean
    suspend fun login(email: String, password: String): Flow<Resource<Unit, FirebaseError>>
    suspend fun register(email: String, password: String): Flow<Resource<Unit, FirebaseError>>
    suspend fun logout(): Flow<Resource<Unit, FirebaseError>>
    fun getUserEmail(): String?
    fun getFirebaseAuthState(): Flow<Boolean>
}