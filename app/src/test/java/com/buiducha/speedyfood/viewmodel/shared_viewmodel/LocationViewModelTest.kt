package com.buiducha.speedyfood.viewmodel.shared_viewmodel

import android.content.Context
import android.location.Location
import com.buiducha.speedyfood.data.repository.GeocodingRepository
import org.junit.Assert.*
import org.junit.Test

class LocationViewModelTest {
    @Test
    fun getLocation_returnsLocationAndGeocoding() {
        // Create a mock context and location
        val context = mock(Context::class.java)
        val location = mock(Location::class.java)
        `when`(location.latitude).thenReturn(37.7749)
        `when`(location.longitude).thenReturn(-122.4194)

        // Create a mock geocoding response
        val geocodingResponse = GeocodingResponse(
            listOf(Result(
                formattedAddress = "San Francisco, CA, USA"
            ))
        )
        val geocodingRepository = mock(GeocodingRepository::class.java)
        `when`(geocodingRepository.getGeocoding("37.7749,-122.4194")).thenReturn(geocodingResponse)

        // Create the view model and call getLocation()
        val viewModel = LocationViewModel()
        viewModel.getLocation(context)

        // Assert that the currentLocation and geocoding values are set correctly
        assertEquals(location, viewModel.currentLocation.value)
        assertEquals("San Francisco, CA, USA", viewModel.geocoding.value)
    }

}