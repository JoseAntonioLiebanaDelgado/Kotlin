package com.example.recyclerview_aleixroldan_joseantonio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val items: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addItems()
        viewConfig()
    }

    private fun addItems() {
        items.add("Item 1")
        items.add("Item 2")
        items.add("Item 3")
        items.add("Item 4")
        items.add("Item 5")
    }

    private fun viewConfig() {
        val rvList = findViewById<RecyclerView>(R.id.rv_list)

        rvList.adapter = ListAdapter(items, this)
        rvList.layoutManager = LinearLayoutManager(this)
    }
}