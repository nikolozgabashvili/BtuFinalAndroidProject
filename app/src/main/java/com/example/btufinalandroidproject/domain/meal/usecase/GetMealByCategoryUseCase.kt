package com.example.btufinalandroidproject.domain.meal.usecase

import com.example.btufinalandroidproject.domain.core.util.DataError
import com.example.btufinalandroidproject.domain.core.util.Resource
import com.example.btufinalandroidproject.domain.meal.model.MealListDomain
import com.example.btufinalandroidproject.domain.meal.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMealByCategoryUseCase @Inject constructor(
    private val repository: MealRepository
) {
    suspend operator fun invoke(category:String): Flow<Resource<MealListDomain, DataError>> {
        return repository.getMealsByCategory(category)

    }
}