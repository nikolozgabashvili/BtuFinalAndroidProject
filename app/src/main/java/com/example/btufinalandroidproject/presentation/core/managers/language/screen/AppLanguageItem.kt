package com.example.btufinalandroidproject.presentation.core.managers.language.screen

import com.example.btufinalandroidproject.domain.core.managers.language.AppLanguage

data class AppLanguageItem(
    val language: AppLanguage,
    val isSelected: Boolean,
    val hadUnderLine:Boolean
)