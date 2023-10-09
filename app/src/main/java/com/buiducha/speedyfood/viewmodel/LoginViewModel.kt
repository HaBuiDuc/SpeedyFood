package com.buiducha.speedyfood.viewmodel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel : ViewModel() {
    private var auth: FirebaseAuth = Firebase.auth

    fun userLogin(
        activity: Activity,
        email: String,
        password: String,
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user?.let {
                        if (it.isEmailVerified) {
                            Log.d(TAG, "login successfully")
                        } else {
                            Log.d(TAG, "login failure")
                        }
                    }
                } else if (task.isCanceled) {
                    Log.d(TAG, "login failure")
                }
            }
            .addOnFailureListener(activity) { _ ->
                Log.d(TAG, "login failure")
            }
    }
    companion object {
        const val TAG = "LoginViewModel"
    }
}