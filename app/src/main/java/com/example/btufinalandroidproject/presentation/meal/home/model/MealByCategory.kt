package com.example.btufinalandroidproject.presentation.meal.home.model

data class MealByCategory(
    val categoryId: String,
    val categoryName: String,
    val meals: List<MealUi>? = null
)