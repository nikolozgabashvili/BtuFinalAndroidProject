package com.example.btufinalandroidproject.domain.meal.usecase

import com.example.btufinalandroidproject.domain.meal.repository.MealLocalDataSource
import javax.inject.Inject

class ClearFavouritesUseCase @Inject constructor(
    private val repository: MealLocalDataSource
) {
    suspend operator fun invoke() {
        repository.clearFavourites()
    }
}