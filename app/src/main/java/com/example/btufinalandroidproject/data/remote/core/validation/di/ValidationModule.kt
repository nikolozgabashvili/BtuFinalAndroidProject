package com.example.btufinalandroidproject.data.remote.core.validation.di

import com.example.btufinalandroidproject.data.remote.core.validation.UserDataValidatorImpl
import com.example.btufinalandroidproject.domain.core.validation.UserDataValidator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ValidationModule {

    @Binds
    @Singleton
    abstract fun bindsUserDataValidator(impl: UserDataValidatorImpl): UserDataValidator
}