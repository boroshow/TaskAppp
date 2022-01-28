package com.example.taskapp.domein

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList() = shopListRepository.getShopList()
}