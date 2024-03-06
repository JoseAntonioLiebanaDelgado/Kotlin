package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ClientView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_view)

        val data = intent.getSerializableExtra("EXTRA_TEXT") as Product
        val textName = findViewById<TextView>(R.id.infoName)
        val textQuantity = findViewById<TextView>(R.id.infoQuantity)

        textName.text = data.name
        textQuantity.text = data.quantity.toString()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}