package com.example.collections_aleixroldangarcia

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var addButton: Button
    private lateinit var revertButton: Button
    private lateinit var clearButton: Button
    private lateinit var calculateButton: Button
    private lateinit var listView: ListView
    private lateinit var items: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        addButton = findViewById(R.id.addButton)
        revertButton = findViewById(R.id.revertButton)
        clearButton = findViewById(R.id.clearButton)
        calculateButton = findViewById(R.id.calculateButton)
        listView = findViewById(R.id.listView)

        items = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter

        addButton.setOnClickListener {
            val newItem = editText.text.toString()
            if (newItem.isNotEmpty()) {
                items.add(newItem)
                adapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }

        revertButton.setOnClickListener {
            items.reverse()
            adapter.notifyDataSetChanged()
        }

        clearButton.setOnClickListener {
            items.clear()
            adapter.notifyDataSetChanged()
        }

        calculateButton.setOnClickListener {
            val numbers = items.mapNotNull { it.toInt() }
            val count = numbers.size
            val sum = numbers.sum()
            val average = if (count > 0) sum / count else 0.0

            Toast.makeText(
                this,
                "Count: $count Sum: $sum Avg: $average", Toast.LENGTH_LONG
            ).show()
        }
    }
}

