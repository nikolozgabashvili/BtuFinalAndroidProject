package com.example.btufinalandroidproject.presentation.meal.favourites

import com.example.btufinalandroidproject.presentation.meal.home.model.MealUi

data class FavouriteScreenState(
    val favourites: List<MealUi> = emptyList()
)
