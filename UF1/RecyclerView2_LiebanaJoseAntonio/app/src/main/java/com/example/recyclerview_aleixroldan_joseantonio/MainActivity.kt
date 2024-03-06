package com.example.recyclerview_aleixroldan_joseantonio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_aleixroldan_joseantonio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val itemList = mutableListOf<String>()
    private lateinit var adapter: MyAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(itemList)
        binding.recyclerView.adapter = adapter

        binding.addButton.setOnClickListener {
            addItem()
        }

        binding.minusButton.setOnClickListener {
            removeItem()
        }

        binding.clearButton.setOnClickListener {
            clearItems()
        }
    }

    private fun addItem() {
        val newItem = "Item ${itemList.size + 1}"
        itemList.add(newItem)
        adapter.notifyDataSetChanged()
    }

    private fun removeItem() {
        if (itemList.isNotEmpty()) {
            itemList.removeAt(itemList.size - 1)
            adapter.notifyDataSetChanged()
        }
    }

    private fun clearItems() {
        itemList.clear()
        adapter.notifyDataSetChanged()
    }
}
