package com.example.btufinalandroidproject.domain.auth.util

import com.example.btufinalandroidproject.domain.core.util.Error

enum class FirebaseError : Error {
    UNKNOWN,
    INVALID_CREDENTIALS,
    INVALID_EMAIL,
    NETWORK_ERROR,
    USER_COLLISION
}