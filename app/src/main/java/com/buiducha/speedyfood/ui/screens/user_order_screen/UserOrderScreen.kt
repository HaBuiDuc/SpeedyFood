package com.buiducha.speedyfood.ui.screens.user_order_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.buiducha.speedyfood.ui.theme.Ivory
import com.buiducha.speedyfood.viewmodel.food_order.UserOrderViewModel

@Composable
fun UserOrderScreen(
    userOrderViewModel: UserOrderViewModel = viewModel()
) {
    val userOrderState by userOrderViewModel.userOrderState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Ivory)
            .verticalScroll(rememberScrollState())
    ) {
        userOrderState.orderList.forEach { orderData ->
            OrderItem(
                orderItem = orderData
            )
        }
    }
}