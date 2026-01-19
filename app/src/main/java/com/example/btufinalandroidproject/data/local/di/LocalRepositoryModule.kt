package com.example.btufinalandroidproject.data.local.di

import com.example.btufinalandroidproject.data.local.repository.MealLocalRepositoryImpl
import com.example.btufinalandroidproject.domain.meal.repository.MealLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsLocalRepository(
        localRepositoryImpl: MealLocalRepositoryImpl
    ): MealLocalDataSource

}
