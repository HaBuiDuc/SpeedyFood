package com.buiducha.speedyfood.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.buiducha.speedyfood.data.model.FoodData
import com.buiducha.speedyfood.ui.states.HomeState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val database = Firebase.database
    private val myRef = database.getReference("foods")
    private val _homeState = MutableStateFlow(HomeState())
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()

    init {
        myRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                Log.d(TAG, "onDataChange: ")
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<Map<String, FoodData>>()
                value?.let {
                    _homeState.value = _homeState.value.copy(
                        foodList = it.values.toMutableList()
                    )
                }
                if (value != null) {
                    Log.d(TAG, "Value is: ${_homeState.value.foodList}")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }

    companion object {
        const val TAG = "HomeViewModel"
    }
}