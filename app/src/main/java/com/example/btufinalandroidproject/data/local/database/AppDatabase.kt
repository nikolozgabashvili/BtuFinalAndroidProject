package com.example.btufinalandroidproject.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.btufinalandroidproject.data.local.database.dao.MealDao
import com.example.btufinalandroidproject.data.local.database.model.MealEntity

@Database(entities = [MealEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDao
}