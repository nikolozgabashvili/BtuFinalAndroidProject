package com.example.btufinalandroidproject.domain.meal.usecase

import com.example.btufinalandroidproject.domain.core.util.DataError
import com.example.btufinalandroidproject.domain.core.util.Resource
import com.example.btufinalandroidproject.domain.meal.model.MealCategoryListDomain
import com.example.btufinalandroidproject.domain.meal.repository.MealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMealCategoriesUseCase @Inject constructor(
    private val repository: MealRepository
) {
    suspend operator fun invoke(): Flow<Resource<MealCategoryListDomain, DataError>> {
        return withContext(Dispatchers.IO) {
            repository.getMealCategories()
        }
    }
}