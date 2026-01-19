package com.example.btufinalandroidproject.presentation.core.managers.language

import android.content.Context

interface LanguageManagerProvider {
    fun provideLanguageManager(): LanguageManager
}


val Context.getLanguageManager: LanguageManager
    get() = (applicationContext as LanguageManagerProvider).provideLanguageManager()