package com.example.btufinalandroidproject.presentation.meal.favourites.detail

import com.example.btufinalandroidproject.presentation.meal.home.screen.details.model.MealDetailUi

data class FavouriteDetailsScreenState(
    val details: MealDetailUi? = null,
    val isFavourite: Boolean = false,
)
