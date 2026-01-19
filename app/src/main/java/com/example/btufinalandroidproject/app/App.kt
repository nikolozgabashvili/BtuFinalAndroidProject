package com.example.btufinalandroidproject.app

import android.app.Application
import com.example.btufinalandroidproject.presentation.core.managers.language.LanguageManager
import com.example.btufinalandroidproject.presentation.core.managers.language.LanguageManagerProvider
import com.example.btufinalandroidproject.presentation.core.managers.theme.ThemeManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application(), LanguageManagerProvider {

    @Inject
    lateinit var themeManager: ThemeManager

    @Inject
    lateinit var languageManager: LanguageManager

    override fun onCreate() {
        super.onCreate()
        themeManager.init()
    }

    override fun provideLanguageManager(): LanguageManager {
        return languageManager
    }
}