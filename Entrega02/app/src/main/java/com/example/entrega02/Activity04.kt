package com.example.entrega02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Activity04 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_04)

        val data = intent.getSerializableExtra("EXTRA_TEXT") as MessageData
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "${data.msg1} - ${data.msg2} - ${data.msg3}"
    }
}