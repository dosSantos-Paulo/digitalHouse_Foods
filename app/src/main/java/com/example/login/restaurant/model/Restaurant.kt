package com.example.login.restaurant.model

import com.example.login.restaurant.model.FoodPlate

data class Restaurant(
    val imageUrl: Int,
    val title: String,
    val address: String,
    val closedAt: String,
    val foodList: List<FoodPlate>
)