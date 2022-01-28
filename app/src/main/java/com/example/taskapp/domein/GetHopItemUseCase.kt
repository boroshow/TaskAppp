package com.example.taskapp.domein

class GetHopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItemList(index: Int) = shopListRepository.getHopItemList(index)

}