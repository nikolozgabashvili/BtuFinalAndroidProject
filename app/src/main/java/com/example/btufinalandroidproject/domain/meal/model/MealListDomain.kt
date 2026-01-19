package com.example.btufinalandroidproject.domain.meal.model

data class MealListDomain(
    val meals: List<MealDomain>
) {
    data class MealDomain(
        val id: String,
        val mealImage: String,
        val mealName: String
    )
}
