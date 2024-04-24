package com.example.espresso_testing2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.espresso_testing2.databinding.ActivityMain2Binding
import com.example.espresso_testing2.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputUsername = intent.getStringExtra("username")
        binding.welcomeText.text = "Welcome, $inputUsername!"
    }
}