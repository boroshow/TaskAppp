package com.example.taskapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_item")
data class ShopItemDBModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val enabled: Boolean,
    val count: Int
)