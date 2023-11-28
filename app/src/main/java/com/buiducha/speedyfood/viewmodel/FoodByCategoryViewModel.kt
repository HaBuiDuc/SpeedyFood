package com.buiducha.speedyfood.viewmodel

import androidx.lifecycle.ViewModel
import com.buiducha.speedyfood.ui.states.FoodByCategoryState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FoodByCategoryViewModel : ViewModel() {
    private val _foodByCategoryState = MutableStateFlow(FoodByCategoryState())
    val foodByCategoryState: StateFlow<FoodByCategoryState> = _foodByCategoryState.asStateFlow()


}