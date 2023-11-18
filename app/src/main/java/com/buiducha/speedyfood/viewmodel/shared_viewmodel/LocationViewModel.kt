package com.buiducha.speedyfood.viewmodel.shared_viewmodel

import android.content.Context
import android.location.Location
import android.util.Log
import androidx.lifecycle.ViewModel
import com.buiducha.speedyfood.data.location.getCurrentLocation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LocationViewModel : ViewModel() {
    private val _currentLocation = MutableStateFlow<Location?>(null)
    val currentLocation: StateFlow<Location?> = _currentLocation.asStateFlow()

    init {

    }

    fun getLocation(
        context: Context
    ) {
        Log.d(TAG, "getLocation: ")
        getCurrentLocation(
            context = context,
            onGetLocationSuccess = {location ->
                _currentLocation.value = location
                Log.d(TAG, location.toString())
            }
        )
    }

    companion object {
        const val TAG = "LocationViewModel"
    }
}