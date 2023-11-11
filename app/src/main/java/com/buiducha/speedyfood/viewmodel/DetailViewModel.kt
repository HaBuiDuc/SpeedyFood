package com.buiducha.speedyfood.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buiducha.speedyfood.data.model.CartItemData
import com.buiducha.speedyfood.data.model.FoodData
import com.buiducha.speedyfood.data.model.OptionalItemData
import com.buiducha.speedyfood.data.repository.FireBaseRepository
import com.buiducha.speedyfood.ui.states.DetailState
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.FoodViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val foodSharedVM: FoodViewModel) : ViewModel() {
//    private val cartRepository = CartRepository.get()
    private val fireBaseRepository = FireBaseRepository.get()
    private val _detailState = MutableStateFlow(DetailState())
    val detailState: StateFlow<DetailState> = _detailState.asStateFlow()

    init {
        viewModelScope.launch {
            foodSharedVM.foodData.collect {data ->
                _detailState.value.food = data
                data!!.toppings.forEach { topping ->
                    Log.d(TAG, topping)
                    fireBaseRepository.getTopping(
                        toppingId = topping
                    ) {
//                        Log.d(TAG, it.toString())
                        _detailState.value.toppingList += it
                    }
                }
            }
        }
    }

    fun updateFood(foodData: FoodData) {
        foodSharedVM.foodUpdate(foodData)
    }

    fun addTopping(itemData: OptionalItemData) {
        val newList = _detailState.value.addedTopping + itemData.id
        _detailState.value = _detailState.value.copy(
            addedTopping = newList.toMutableSet()
        )
    }

    fun deleteTopping(itemData: OptionalItemData) {
        val newList = _detailState.value.addedTopping - itemData.id
        _detailState.value = _detailState.value.copy(
            addedTopping = newList.toMutableSet()
        )
    }

    fun addQuantity() {
        val newQuantity = _detailState.value.itemQuantity + 1
        _detailState.value = _detailState.value.copy(
            itemQuantity = newQuantity
        )
    }

    fun subQuantity() {
        val newQuantity = _detailState.value.itemQuantity - 1
        _detailState.value = _detailState.value.copy(
            itemQuantity = newQuantity
        )
    }

    fun getTopping(
        toppingId: String,
        onToppingListener: (OptionalItemData) -> Unit
    ) {
        fireBaseRepository.getTopping(
            toppingId = toppingId,
            onToppingListener = onToppingListener
        )
    }

//    fun addToCart() {
//        detailState.value.food?.let {
//            CartItemData(
//                foodId = it.id!!,
//                totalPrice = detailState.value.totalPrice / detailState.value.itemQuantity,
//                quantity = detailState.value.itemQuantity
//            )
//        }
//    }

    companion object {
        const val TAG = "DetailViewModel"
    }
}

