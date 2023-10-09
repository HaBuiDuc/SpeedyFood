package com.buiducha.speedyfood.data.model

data class OptionalItemData(
    val name: String = "",
    val price: Double = 0.0
) {
    fun getPriceTag() = "+ $price"
}
