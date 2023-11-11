package com.buiducha.speedyfood.data.repository

import android.content.Context
import androidx.room.Room
import com.buiducha.speedyfood.data.local.CartDatabase
import com.buiducha.speedyfood.data.model.CartItemData
import kotlinx.coroutines.flow.Flow

class CartRepository private constructor(context: Context){
    private val database = Room.databaseBuilder(
        context.applicationContext,
        CartDatabase::class.java,
        DATABASE_NAME
    ).build()

    fun getCart(): Flow<List<CartItemData>> = database.cartDao().getCart()

    suspend fun addItem(itemData: CartItemData) = database.cartDao().addItem(itemData)

    companion object {
        const val DATABASE_NAME = "shopping_cart"

        private var INSTANCE: CartRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CartRepository(context)
            }
        }

        fun get(): CartRepository {
            return INSTANCE?: throw IllegalStateException("repository must be init")
        }
    }
}