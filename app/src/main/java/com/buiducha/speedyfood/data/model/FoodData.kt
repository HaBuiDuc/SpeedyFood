package com.buiducha.speedyfood.data.model

data class FoodData(
    val name: String? = "haha",
    val price: Double? = 0.0,
    val imageUri: String? = "",
    val toppings: List<OptionalItemData> = emptyList(),
    val type: String = ""
)
