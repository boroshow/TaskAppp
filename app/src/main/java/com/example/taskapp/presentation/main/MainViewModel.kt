package com.example.taskapp.presentation.main

import androidx.lifecycle.ViewModel
import com.example.taskapp.data.ShopListRepositoryImpl
import com.example.taskapp.domein.*

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val getShopItemListUseCase = GetShopItemUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val getHopItemUseCase = GetHopItemUseCase(repository)
    val shopList = getShopItemListUseCase.getShopList()

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem) {
        editShopItemUseCase.editShopItem(shopItem)
    }

    fun getHopItem(index: Int) {
        getHopItemUseCase.getShopItemList(index)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}