package com.example.btufinalandroidproject.presentation.auth.util

import android.content.Context
import com.example.btufinalandroidproject.R
import com.example.btufinalandroidproject.domain.auth.util.FirebaseError

fun FirebaseError.toErrorString(context: Context): String {
    return when (this) {
        FirebaseError.INVALID_CREDENTIALS -> {
            context.getString(R.string.invalid_credentials)
        }

        FirebaseError.INVALID_EMAIL -> {
            context.getString(R.string.invalid_email)
        }

        FirebaseError.NETWORK_ERROR -> {
            context.getString(R.string.network_error)
        }

        FirebaseError.USER_COLLISION -> {
            context.getString(R.string.user_collision)
        }

        else -> {
            context.getString(R.string.unknown_error)
        }
    }
}