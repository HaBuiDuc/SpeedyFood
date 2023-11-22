package com.buiducha.speedyfood.data.repository

import android.app.Activity
import android.content.Context
import android.util.Log
import com.buiducha.speedyfood.data.model.FoodData
import com.buiducha.speedyfood.data.model.OptionalItemData
import com.buiducha.speedyfood.data.model.OrderData
import com.buiducha.speedyfood.data.model.UserData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class FireBaseRepository private constructor(context: Context) {
    private val database = Firebase.database
    private val foodsRef = database.getReference("foods")
    private val toppingsRef = database.getReference("toppings")
    private val usersRef = database.getReference("users")
    private val orderRef = database.getReference("orders")
    private var auth: FirebaseAuth = Firebase.auth

    fun getCurrentUser() = auth.currentUser

    fun placeOrder(
        orderData: OrderData,
        onOrderSuccess: () -> Unit,
        onOrderFailure: () -> Unit
    ) {
        orderRef.push().setValue(orderData)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d(TAG, "add order success")
                    onOrderSuccess()
                }
            }
            .addOnFailureListener {e ->
                Log.e(TAG, "add order failure", e)
                onOrderFailure()
            }
    }

    fun getUserInfo(userId: String) {
        usersRef.orderByChild("id").equalTo(userId).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    fun isUserInfoExists(
        userId: String,
        onUserExists: () -> Unit,
        onUserNotExists: () -> Unit
    ) {
        usersRef.orderByChild("id").equalTo(userId).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d(TAG, snapshot.value.toString())
                if (snapshot.exists()) {
                    onUserExists()
                    Log.d(TAG, "user exists")
                } else {
                    onUserNotExists()
                    Log.d(TAG, "user not exists")
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    fun addUserInfo(
        userData: UserData,
        onAddSuccess: () -> Unit,
        onAddFailure: () -> Unit
    ) {
        usersRef.push().setValue(userData)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d(TAG, "add user success")
                    onAddSuccess()
                }
            }
            .addOnFailureListener {e ->
                Log.e(TAG, "add user failure", e)
                onAddFailure()
            }
    }

    fun createUser(
        activity: Activity,
        email: String,
        password: String,
        onCreateSuccess: () -> Unit,
        onCreateFailure: () -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    onCreateSuccess()
                    val user = auth.currentUser
                    user?.sendEmailVerification()
                    Log.d(TAG, "create user successfully")
                } else if (task.isCanceled) {
                    Log.d(TAG, "create user failure")
                    onCreateFailure()
                }
            }
            .addOnFailureListener {
                onCreateFailure()
            }
    }

    fun userLogin(
        activity: Activity,
        email: String,
        password: String,
        onLoginSuccess: () -> Unit,
        onLoginFailure: (String) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user?.let {
                        if (it.isEmailVerified) {
                            Log.d(TAG, "login successfully")
                            onLoginSuccess()
                        } else {
                            Log.d(TAG, "email not verified")
                            onLoginFailure("Email is not verified")
                        }
                    }
                } else if (task.isCanceled) {
                    Log.d(TAG, "login failure")
                }
            }
            .addOnFailureListener(activity) { _ ->
                Log.d(TAG, "login failure")
                onLoginFailure("Login failure")
            }
    }

    fun getFood(
        foodId: String,
        onGetFoodSuccess: (FoodData) -> Unit
    ) {
        foodsRef.orderByChild("id").equalTo(foodId).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach { shot ->
                    Log.d(TAG, shot.value.toString())
                    val data = shot.getValue(FoodData::class.java)
                    data?.let(onGetFoodSuccess)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    fun foodDataListener(
        foodDataUpdate: (MutableList<FoodData>) -> Unit
    ) {
        foodsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                Log.d(TAG, "onDataChange: ")
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(TAG, "foodDataListener: ")
                val value = dataSnapshot.getValue<Map<String, FoodData>>()
                value?.let {
                    foodDataUpdate(it.values.toMutableList())
                }
                if (value != null) {
                    Log.d(TAG, "Value is: $value")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }

    fun getTopping(
        toppingId: String,
        onToppingListener: (OptionalItemData) -> Unit
    ) {
        toppingsRef.orderByChild("id").equalTo(toppingId).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach { shot ->
                    Log.d(TAG, shot.value.toString())
                    val data = shot.getValue(OptionalItemData::class.java)
                    onToppingListener(data!!)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG, "onCancelled: failure to get data", )
            }

        })
    }
    companion object {
        const val TAG = "FireBaseRepository"
        private var INSTANCE: FireBaseRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = FireBaseRepository(context)
            }
        }

        fun get(): FireBaseRepository {
            return INSTANCE ?: throw  IllegalStateException("repo must be init")
        }
    }
}