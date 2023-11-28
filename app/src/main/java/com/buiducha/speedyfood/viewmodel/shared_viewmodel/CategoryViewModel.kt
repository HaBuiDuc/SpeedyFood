package com.buiducha.speedyfood.viewmodel.shared_viewmodel

import androidx.lifecycle.ViewModel
import com.buiducha.speedyfood.data.model.FoodData
import com.buiducha.speedyfood.data.repository.FireBaseRepository
import kotlinx.coroutines.flow.MutableStateFlow

class CategoryViewModel : ViewModel() {
    private val fireBaseRepository = FireBaseRepository.get()
    private val _foodDataList = MutableStateFlow<List<FoodData>>(emptyList())

}