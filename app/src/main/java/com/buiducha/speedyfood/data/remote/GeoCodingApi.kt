package com.buiducha.speedyfood.data.remote

import com.buiducha.speedyfood.data.model.geo_coding.GeocodingResult
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoCodingApi {
    @GET("geocode/json?key=AIzaSyCpSXJBj30p3SFd7XQjce6EnjA-uYc48N4")
    suspend fun getGeocoding(
        @Query("latlng") latLng: String
    ): GeocodingResult
}