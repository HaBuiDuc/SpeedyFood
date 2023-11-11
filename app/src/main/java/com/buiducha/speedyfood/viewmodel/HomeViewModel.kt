package com.buiducha.speedyfood.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.buiducha.speedyfood.data.repository.FireBaseRepository
import com.buiducha.speedyfood.ui.states.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val fireBaseRepository = FireBaseRepository.get()
    private val _homeState = MutableStateFlow(HomeState())
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()

    init {
        fireBaseRepository.foodDataListener {
            _homeState.value = _homeState.value.copy(
                foodList = it
            )
            Log.d(TAG, it.toString())
        }
    }

    companion object {
        const val TAG = "HomeViewModel"
    }
}