package com.buiducha.speedyfood.ui.states

import com.buiducha.speedyfood.data.model.FoodData

data class DetailState(
    val food: FoodData? = null,
    val itemQuantity: Int = 0,
    val totalPrice: Double = 0.0
)
