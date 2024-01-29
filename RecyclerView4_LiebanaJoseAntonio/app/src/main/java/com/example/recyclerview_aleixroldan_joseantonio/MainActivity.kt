package com.example.recyclerview_aleixroldan_joseantonio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var productNameEditText: EditText
    private lateinit var quantityTextView: TextView
    private lateinit var decreaseButton: Button
    private lateinit var increaseButton: Button
    private lateinit var addButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private val productList = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productNameEditText = findViewById(R.id.productNameEditText)
        quantityTextView = findViewById(R.id.quantityEditText)
        decreaseButton = findViewById(R.id.decreaseButton)
        increaseButton = findViewById(R.id.increaseButton)
        addButton = findViewById(R.id.addButton)
        recyclerView = findViewById(R.id.recyclerView)

        productAdapter = ProductAdapter(productList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = productAdapter

        decreaseButton.setOnClickListener {
            decreaseQuantity()
        }

        increaseButton.setOnClickListener {
            increaseQuantity()
        }

        addButton.setOnClickListener {
            addProduct()
        }
    }

    private fun decreaseQuantity() {
        val currentQuantity = quantityTextView.text.toString().toInt()
        if (currentQuantity > 0) {
            quantityTextView.text = (currentQuantity - 1).toString()
        }
    }

    private fun increaseQuantity() {
        val currentQuantity = quantityTextView.text.toString().toInt()
        quantityTextView.text = (currentQuantity + 1).toString()
    }
    private fun addProduct() {
        val productName = productNameEditText.text.toString()
        val productQuantity = quantityTextView.text.toString().toInt()
        if (productName.isNotEmpty() && productQuantity > 0) {
            val product = Product(productName, productQuantity)
            productList.add(product)
            productAdapter.notifyItemInserted(productList.size - 1)


            productNameEditText.text.clear()
            quantityTextView.text = "0"
        }
    }
}
