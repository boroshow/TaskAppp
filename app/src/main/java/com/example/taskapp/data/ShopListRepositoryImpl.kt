package com.example.taskapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.taskapp.App
import com.example.taskapp.domein.ShopItem
import com.example.taskapp.domein.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private var autoIncrementId = 0
    private val mapper = ShopListMapper()

    override fun addShopItem(shopItem: ShopItem) {
        App.appDatabase.shopList().insertShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        App.appDatabase.shopList().deleteShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun getShopList(): LiveData<List<ShopItem>> =
        Transformations.map(App.appDatabase.shopList().getShopList()) {
            mapper.mapListDBToListEntity(it)
        }

    override fun editShopItem(shopItem: ShopItem) {
        App.appDatabase.shopList().editShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun getHopItemList(index: Int): ShopItem {
//        return shopList.find {
//            it.id == index
//        } ?: throw RuntimeException("Element with id $index not found")
//    }
        val dbModel = App.appDatabase.shopList().getShopItem(index)
        return mapper.mapDbModelToEntity(dbModel)
    }
}