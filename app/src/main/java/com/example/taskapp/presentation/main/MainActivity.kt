package com.example.taskapp.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.taskapp.R
import com.example.taskapp.databinding.ActivityMainBinding
import com.example.taskapp.domein.ShopItem
import com.example.taskapp.presentation.second.SecondActivity

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()
    private lateinit var shopAdapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        initObservers()
        initListeners()
    }

    private fun initObservers() {
        viewModel.shopList.observe(this, {
            shopAdapter.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        with(binding.rvRecycler) {
            shopAdapter = ShopListAdapter()
            adapter = shopAdapter
        }
        setupSwipeListener(binding.rvRecycler)
    }

    private fun setupSwipeListener(rv: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = shopAdapter.currentList[viewHolder.absoluteAdapterPosition]
                viewModel.deleteShopItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rv)
    }

    private fun initListeners() {
        shopAdapter.onShopItemClickListener = {
            viewModel.editShopItem(it)
        }
        binding.btnAdd.setOnClickListener {
            Intent(this, SecondActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun addShopItemfun() {
        viewModel.addShopItem(ShopItem("Potato", 2, false, 1))
    }
}