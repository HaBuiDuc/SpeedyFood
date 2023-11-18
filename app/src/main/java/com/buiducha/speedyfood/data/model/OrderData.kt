package com.buiducha.speedyfood.data.model

import java.util.UUID

data class OrderData(
    val orderId: String = UUID.randomUUID().mostSignificantBits.toString(),
    val userId: String,
    val address: String,

)
