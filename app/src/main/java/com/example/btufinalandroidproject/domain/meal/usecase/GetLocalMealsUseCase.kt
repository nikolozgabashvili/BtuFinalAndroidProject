package com.example.btufinalandroidproject.domain.meal.usecase

import com.example.btufinalandroidproject.domain.meal.repository.MealLocalDataSource
import javax.inject.Inject

class GetLocalMealsUseCase @Inject constructor(
    private val repository: MealLocalDataSource
) {
    operator fun invoke() = repository.getMeals()

}