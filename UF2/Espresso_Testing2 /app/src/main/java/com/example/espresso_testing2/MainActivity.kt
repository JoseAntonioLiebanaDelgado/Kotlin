package com.example.espresso_testing2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.espresso_testing2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val inputUsername = binding.inputUsername.text.toString()
            val inputPassword = binding.inputPassword.text.toString()

            if ((inputUsername == "guest" && inputPassword == "guest") || (inputUsername == "admin" && inputPassword == "admin")) {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("username", inputUsername)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Wrong user or password.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}