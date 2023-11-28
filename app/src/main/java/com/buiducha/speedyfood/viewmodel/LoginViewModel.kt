package com.buiducha.speedyfood.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import com.buiducha.speedyfood.MainActivity
import com.buiducha.speedyfood.data.repository.FireBaseRepository
import com.buiducha.speedyfood.utils.startMainActivity

class LoginViewModel : ViewModel() {
    private val fireBaseRepository = FireBaseRepository.get()

    init {

    }

    fun authStateCheck(
        onUserExists: () -> Unit,
        onUserNotExists: () -> Unit
    ) {
        if (fireBaseRepository.getCurrentUser() != null) {
            Log.d(TAG, "Auto login without input: ")
            onLoginSuccess(
                onUserExists = onUserExists,
                onUserNotExists = onUserNotExists
            )
        }
    }

    fun userLogin(
        activity: Activity,
        email: String,
        password: String,
        onLoginSuccess: () -> Unit,
        onLoginFailure: (String) -> Unit
    ) {
        fireBaseRepository.userLogin(
            activity = activity,
            email = email,
            password = password,
            onLoginSuccess = onLoginSuccess,
            onLoginFailure = onLoginFailure
        )
    }

    fun onLoginSuccess(
        onUserExists: () -> Unit,
        onUserNotExists: () -> Unit
    ) {
        fireBaseRepository.isUserInfoExists(
            userId = fireBaseRepository.getCurrentUser()?.uid!!,
            onUserExists = onUserExists,
            onUserNotExists = onUserNotExists
        )
    }

    fun isValueValid(
        email: String,
        password: String,
    ): Boolean = email.isNotEmpty() && password.isNotEmpty()
    companion object {
        const val TAG = "LoginViewModel"
    }
}