package com.example.btufinalandroidproject.presentation.core.managers.theme

import com.example.btufinalandroidproject.domain.core.managers.theme.Theme

data class ThemeItem(
    val theme: Theme,
    val isSelected: Boolean,
    val hasUnderLine: Boolean
)
