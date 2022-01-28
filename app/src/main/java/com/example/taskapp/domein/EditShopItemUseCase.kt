package com.example.taskapp.domein

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem( shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}