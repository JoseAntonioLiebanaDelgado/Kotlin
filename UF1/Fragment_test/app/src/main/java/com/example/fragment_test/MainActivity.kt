package com.example.fragment_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.addButton.setOnClickListener {
            val param1 = binding.editText1.text.toString().split("\\s+".toRegex())
            val param2 = binding.editText2.text.toString().split("\\s+".toRegex())
            val param3 = binding.editText3.text.toString().split("\\s+".toRegex())

            val redFragment = supportFragmentManager.findFragmentById(R.id.redFragment1)
            if (redFragment == null) {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.redFragment1, BlankFragment_Red.newInstance(param1.getOrNull(0) ?: "", param1.getOrNull(1) ?: "", param3.getOrNull(0) ?: ""))
                    .commit()
            } else {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.redFragment1, BlankFragment_Red.newInstance(param1.getOrNull(0) ?: "", param1.getOrNull(1) ?: "", param3.getOrNull(0) ?: ""))
                    .commit()
            }

            val blueFragment = supportFragmentManager.findFragmentById(R.id.blueFragment2)
            if (blueFragment == null) {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.blueFragment2, BlankFragment_Blue.newInstance(param2.getOrNull(0) ?: "", param2.getOrNull(1) ?: "", param3.getOrNull(1) ?: ""))
                    .commit()
            } else {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.blueFragment2, BlankFragment_Blue.newInstance(param2.getOrNull(0) ?: "", param2.getOrNull(1) ?: "", param3.getOrNull(1) ?: ""))
                    .commit()
            }
        }
    }
}