package com.buiducha.speedyfood.viewmodel.food_order

import androidx.lifecycle.ViewModel
import com.buiducha.speedyfood.data.repository.FireBaseRepository
import com.buiducha.speedyfood.ui.states.UserOrderState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserOrderViewModel : ViewModel() {
    private val fireBaseRepository = FireBaseRepository.get()
    private val _userOrderState = MutableStateFlow(UserOrderState())
    val userOrderState: StateFlow<UserOrderState> = _userOrderState.asStateFlow()

    init {
        getOrder()
    }

    private fun getOrder() {
        fireBaseRepository.getOrder(
            userId = fireBaseRepository.getCurrentUser()?.uid!!,
            onGetOrderSuccess = {orderData ->
                _userOrderState.value = _userOrderState.value.copy(
                    orderList = orderData.toMutableList()
                )
            },
            onGetOrderFailure = {

            }
        )
    }
}