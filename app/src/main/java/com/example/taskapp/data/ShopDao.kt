package com.example.taskapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShopDao {

    @Query("SELECT * FROM shop_item")
    fun getShopList(): LiveData<List<ShopItemDBModel>>

    @Query("SELECT * FROM shop_item WHERE id=:shopItemId LIMIT 1")
    fun getShopItem(shopItemId: Int): ShopItemDBModel

    @Insert
    fun insertShopItem(shopItemDBModel: ShopItemDBModel)

    @Delete
    fun deleteShopItem(shopItemDBModel: ShopItemDBModel)

    @Update
    fun editShopItem(shopItemDBModel: ShopItemDBModel)
}