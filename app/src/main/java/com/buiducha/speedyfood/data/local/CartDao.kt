package com.buiducha.speedyfood.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.buiducha.speedyfood.data.model.CartItemData
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_item_data")
    fun getCart(): Flow<List<CartItemData>>

    @Insert
    suspend fun addItem(item: CartItemData)
}