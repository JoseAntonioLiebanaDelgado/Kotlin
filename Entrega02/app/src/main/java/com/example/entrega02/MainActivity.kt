package com.example.entrega02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.entrega02.databinding.ActivityMainBinding
import java.io.Serializable

data class MessageData(val msg1: String, val msg2: String, val msg3: String) : Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        findViewById<Button>(R.id.button).setOnClickListener {
            val nameEditText = findViewById<EditText>(R.id.editTextNumber)
            val intent = Intent(this, Activity02::class.java)
            intent.putExtra("EXTRA_TEXT", MessageData(nameEditText.text.toString(), "", ""))
            startActivity(intent)
        }
    }
}