package com.example.login

data class Restaurant(
    val imageUrl: Int,
    val title: String,
    val address: String,
    val closedAt: String,
    val foodList: List<FoodPlate>
)