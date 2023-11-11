package com.buiducha.speedyfood.viewmodel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import com.buiducha.speedyfood.data.repository.FireBaseRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterViewModel : ViewModel() {
    private val fireBaseRepository = FireBaseRepository.get()

    fun createUser(
        activity: Activity,
        email: String,
        password: String,
        onCreateSuccess: () -> Unit,
        onCreateFailure: () -> Unit
    ) {
        fireBaseRepository.createUser(
            activity = activity,
            email = email,
            password = password,
            onCreateSuccess = onCreateSuccess,
            onCreateFailure = onCreateFailure
        )
    }

    fun isValueValid(
        email: String,
        password: String,
    ): Boolean = email.isNotEmpty() && password.isNotEmpty()

    companion object {
        const val TAG = "RegisterViewModel"
    }
}