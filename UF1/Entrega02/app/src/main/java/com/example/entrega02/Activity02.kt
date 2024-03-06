package com.example.entrega02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Activity02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_02)

        val data = intent.getSerializableExtra("EXTRA_TEXT") as MessageData

        findViewById<Button>(R.id.button2).setOnClickListener {
            val nameEditText2 = findViewById<EditText>(R.id.editTextNumber2)
            val updatedData = data.copy(msg2 = nameEditText2.text.toString())
            val intent2 = Intent(this, Activity03::class.java)
            intent2.putExtra("EXTRA_TEXT", updatedData)
            startActivity(intent2)
            finish()
        }
    }
}