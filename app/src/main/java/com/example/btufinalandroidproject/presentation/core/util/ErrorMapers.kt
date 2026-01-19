package com.example.btufinalandroidproject.presentation.core.util

import android.content.Context
import com.example.btufinalandroidproject.R
import com.example.btufinalandroidproject.domain.core.util.DataError

fun DataError.toErrorString(context: Context): String {
    return when (this) {
        DataError.DynamicError.NETWORK_ERROR -> {
            context.getString(R.string.network_error)
        }

        DataError.DynamicError.UNKNOWN -> {
            context.getString(R.string.unknown_error)
        }

        is DataError.Literal -> {
            this.errorString ?: ""
        }
    }
}