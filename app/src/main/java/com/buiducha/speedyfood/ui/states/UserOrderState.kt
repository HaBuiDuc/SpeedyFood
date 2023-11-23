package com.buiducha.speedyfood.ui.states

import com.buiducha.speedyfood.data.model.OrderData

data class UserOrderState(
    val orderList: MutableList<OrderData> = mutableListOf()
)
