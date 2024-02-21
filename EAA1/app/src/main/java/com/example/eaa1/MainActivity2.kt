package com.example.eaa1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val suma = intent.getSerializableExtra("suma") as Suma
        val resultat = suma.operand1 + suma.operand2
        findViewById<TextView>(R.id.textResult).text = resultat.toString()

        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}