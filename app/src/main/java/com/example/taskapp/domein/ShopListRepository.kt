package com.example.taskapp.domein

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun getShopList(): LiveData<List<ShopItem>>

    fun editShopItem(shopItem: ShopItem)

    fun getHopItemList(index: Int): ShopItem

}