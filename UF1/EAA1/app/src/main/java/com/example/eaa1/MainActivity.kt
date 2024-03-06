package com.example.eaa1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonSuma).setOnClickListener{
            val operand1 =  findViewById<TextView>(R.id.inputText1).text.toString().toDoubleOrNull() ?: 0.0
            val operand2 =  findViewById<TextView>(R.id.inputText2).text.toString().toDoubleOrNull() ?: 0.0
            val suma = Suma(operand1, operand2)

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("suma", suma)
            startActivity(intent)
        }
    }
}