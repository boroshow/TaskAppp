package com.example.taskapp.presentation.second

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.taskapp.R
import com.example.taskapp.databinding.ActivitySecondBinding
import com.example.taskapp.domein.ShopItem
import com.example.taskapp.presentation.main.MainViewModel

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by viewBinding()
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding.btnAdd.setOnClickListener {
            addShopItem()
        }
    }

    private fun addShopItem() {
        if (binding.etName.text.isNotEmpty() &&
            binding.etCount.text.toString().isNotEmpty() &&
            binding.etId.text.isNotEmpty()
        ) {
            model.addShopItem(
                ShopItem(
                    binding.etName.text.toString(),
                    Integer.parseInt(binding.etCount.text.toString()),
                    false,
                    Integer.parseInt(binding.etId.text.toString())
                )
            )
            finish()
        }
    }
}