package com.buiducha.speedyfood

import android.app.Application
import com.buiducha.speedyfood.data.repository.CartRepository
import com.buiducha.speedyfood.data.repository.FireBaseRepository
import com.google.firebase.auth.FirebaseAuth

class SpeedyFoodApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CartRepository.initialize(this)
        FireBaseRepository.initialize(this)
    }
}