package com.example.btufinalandroidproject.domain.meal.usecase

import com.example.btufinalandroidproject.domain.core.util.DataError
import com.example.btufinalandroidproject.domain.core.util.Resource
import com.example.btufinalandroidproject.domain.meal.model.MealDetailListDomain
import com.example.btufinalandroidproject.domain.meal.repository.MealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMealDetailsByIdUseCase @Inject constructor(
    private val repository: MealRepository
) {
    suspend operator fun invoke(id: String): Flow<Resource<MealDetailListDomain.MealDetailDomain, DataError>> {
        return withContext(Dispatchers.IO) {
            repository.getMealById(id)
        }
    }
}