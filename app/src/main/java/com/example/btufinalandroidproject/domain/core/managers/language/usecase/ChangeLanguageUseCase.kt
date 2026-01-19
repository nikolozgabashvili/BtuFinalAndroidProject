package com.example.btufinalandroidproject.domain.core.managers.language.usecase

import com.example.btufinalandroidproject.domain.core.managers.language.AppLanguage
import com.example.btufinalandroidproject.domain.core.managers.language.repository.LanguageRepository
import javax.inject.Inject

class ChangeLanguageUseCase @Inject constructor(
    private val languageRepository: LanguageRepository
) {
    suspend operator fun invoke(language: AppLanguage) {
        languageRepository.setSelectedLanguage(language)
    }
}