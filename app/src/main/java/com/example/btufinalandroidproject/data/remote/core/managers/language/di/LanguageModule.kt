package com.example.btufinalandroidproject.data.remote.core.managers.language.di

import com.example.btufinalandroidproject.data.remote.core.managers.language.repository.LanguageRepositoryImpl
import com.example.btufinalandroidproject.domain.core.managers.language.repository.LanguageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class LanguageModule {

    @Binds
    @Singleton
    abstract fun bindsLanguageRepository(
        languageRepositoryImpl: LanguageRepositoryImpl
    ): LanguageRepository

}