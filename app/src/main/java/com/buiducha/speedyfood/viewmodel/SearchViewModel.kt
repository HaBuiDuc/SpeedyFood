package com.buiducha.speedyfood.viewmodel

import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import com.buiducha.speedyfood.data.model.FoodData
import com.buiducha.speedyfood.ui.states.SearchState
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.FoodViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class SearchViewModel(private val foodViewModel: FoodViewModel) : ViewModel() {
    private val _searchState = MutableStateFlow(SearchState())
    val searchState: StateFlow<SearchState> = _searchState.asStateFlow()

    init {

    }

    fun setSearchQuery(query: String) {

        val resultList = if (query.isEmpty()) {
            emptyList()
        } else {
            foodViewModel.foodDataList.value.filter { foodData -> foodData.name!!.lowercase(Locale.ENGLISH).contains(query) }
        }
        _searchState.value = _searchState.value.copy(
            searchQuery = query,
            suggestionList = resultList
        )
    }
}