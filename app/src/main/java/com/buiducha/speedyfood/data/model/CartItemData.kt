package com.buiducha.speedyfood.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity("cart_item_data")
data class CartItemData(
    @PrimaryKey
    val cartItemId: UUID = UUID.randomUUID(),
    val userId: String,
    val foodId: String,
//    val addedTopping: MutableSet<String>,
//    val totalPrice: Double,
    val quantity: Int
) {
//    val totalPrice: Double
//        get() =
}
