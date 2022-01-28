package com.example.taskapp.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.R
import com.example.taskapp.domein.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ShopListAdapter.ShopItemViewHolder>(
    ShopItemDiffCallback()
) {
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when (viewType) {
            ENABLED -> R.layout.item_shop_disabled
            DISABLED -> R.layout.item_shop_enabled
            else -> throw RuntimeException("SHIT CODE: $viewType")
        }
        return ShopItemViewHolder(
            LayoutInflater.from(parent.context).inflate(layout, parent, false)
        )
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enabled) {
            ENABLED
        } else DISABLED
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        holder.onBind(getItem(holder.absoluteAdapterPosition))
    }


    inner class ShopItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(shopItem: ShopItem) {
            itemView.setOnLongClickListener {
                onShopItemClickListener?.invoke(shopItem)
                true
            }
            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()
        }

        val tvName = itemView.findViewById<TextView>(R.id.tv_name)!!
        val tvCount = itemView.findViewById<TextView>(R.id.tv_count)!!
    }

    companion object {
        const val ENABLED = 1
        const val DISABLED = 0
    }
}