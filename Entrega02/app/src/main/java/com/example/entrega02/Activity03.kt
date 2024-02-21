package com.example.entrega02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Activity03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_03)

        val data = intent.getSerializableExtra("EXTRA_TEXT") as MessageData

        findViewById<Button>(R.id.button3).setOnClickListener {
            val nameEditText3 = findViewById<EditText>(R.id.editTextNumber3)
            val updatedData = data.copy(msg3 = nameEditText3.text.toString())
            val intent3 = Intent(this, Activity04::class.java)
            intent3.putExtra("EXTRA_TEXT", updatedData)
            startActivity(intent3)
            finish()
        }
    }
}