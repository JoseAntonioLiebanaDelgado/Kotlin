    package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val items: MutableList<Product> = mutableListOf()
    private lateinit var rvList: RecyclerView
    private var listAdapter = ListAdapter(items, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.countView.text = "0"

        addItems()
        viewConfig()

        binding.add.setOnClickListener{
            var name = binding.clientName.text.toString()
            var quantity = binding.countView.text.toString().toInt()
            if (quantity != 0) {
                addNewItem(name, quantity)
            }
            listAdapter.notifyDataSetChanged()
        }

        binding.minusButton.setOnClickListener{
            var quant = binding.countView.text.toString().toInt()
            if (quant != 0){
                quant-=1
            }
            binding.countView.text = quant.toString()
        }

        binding.moreButton.setOnClickListener{
            var quant = binding.countView.text.toString().toInt()
            quant+=1
            binding.countView.text = quant.toString()
        }

    }

    private fun addItems(){
        items.add(Product("Pizza", 1))
        items.add(Product("Tomato", 1))
        items.add(Product("Tortilla", 2))
        items.add(Product("Bacon", 1))
        items.add(Product("Eggs", 4))
    }

    private fun popLastItem(){
        val num = ListAdapter(items, this).itemCount
        items.removeAt(num - 1)
    }

    private fun addNewItem(name: String, quantity: Int){
        items.add(Product(name, quantity))
    }

    private fun clearItems(){
        items.clear()
    }

    private fun viewConfig(){
        rvList = findViewById<RecyclerView>(R.id.rv_list)
        rvList.adapter = listAdapter
        rvList.layoutManager = LinearLayoutManager(this)
        listAdapter.notifyDataSetChanged()
    }
}