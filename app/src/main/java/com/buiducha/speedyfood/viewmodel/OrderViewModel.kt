package com.buiducha.speedyfood.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buiducha.speedyfood.data.repository.CartRepository
import com.buiducha.speedyfood.data.repository.FireBaseRepository
import com.buiducha.speedyfood.ui.states.OrderState
import com.buiducha.speedyfood.utils.getAddress
import com.buiducha.speedyfood.utils.getThoroughfare
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.LocationViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class OrderViewModel(
    private val locationViewModel: LocationViewModel
) : ViewModel() {
    private val cartRepository = CartRepository.get()
    private val fireBaseRepository = FireBaseRepository.get()
    private val _orderState = MutableStateFlow(OrderState())
    val orderState: StateFlow<OrderState> = _orderState.asStateFlow()

    init {
        getCart()
    }

    fun setNote(note: String) {
        _orderState.value = _orderState.value.copy(
            note = note
        )
    }

    fun getLocation(context: Context) {
        viewModelScope.launch {
            locationViewModel.currentLocation.collect {location ->
                _orderState.value = _orderState.value.copy(
                    thoroughfare = location?.getThoroughfare(context)!!,
                    address = location.getAddress(context)
                )
            }
        }
        Log.d(TAG, "getLocation in order")
    }

    private fun getCart() {
        viewModelScope.launch {
            cartRepository.getCart().collect {cartItems ->
                val newFoodItems = _orderState.value.foodItems.toMutableList()

                cartItems.forEach { cart ->
                    val foodItem = suspendCoroutine { continuation ->
                        fireBaseRepository.getFood(foodId = cart.foodId) { foodItem ->
                            continuation.resume(foodItem)
                        }
                    }
                    newFoodItems += foodItem
                }
                Log.d(CartViewModel.TAG, newFoodItems.size.toString())
                _orderState.value = _orderState.value.copy(
                    cartItems = cartItems,
                    foodItems = newFoodItems
                )
            }
        }
    }

    fun placeOrder() {

    }
    companion object {
        const val TAG = "OrderViewModel"
    }
}