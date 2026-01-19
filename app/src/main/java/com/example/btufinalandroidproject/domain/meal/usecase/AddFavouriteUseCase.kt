package com.example.btufinalandroidproject.domain.meal.usecase

import com.example.btufinalandroidproject.domain.meal.model.MealDetailListDomain
import com.example.btufinalandroidproject.domain.meal.repository.MealLocalDataSource
import javax.inject.Inject

class AddFavouriteUseCase @Inject constructor(
    private val repository: MealLocalDataSource
) {
    suspend operator fun invoke(meal:MealDetailListDomain.MealDetailDomain) {
        repository.addMealToFavourites(meal)
    }
}