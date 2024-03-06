package com.example.collections

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.collections.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val numbers = mutableListOf<String>()
        val input = binding.inNumbers
        var suma = 0
        var count = 0
        var avg = 0

        binding.button.setOnClickListener{
            if (input.text.isNotEmpty()) {
                numbers.add(input.text.toString())
                binding.textView.text = numbers.joinToString(separator = ", ")
                binding.inNumbers.text.clear()
            } else {
                binding.textView.text = "Please enter a number"
            }
        }

        binding.reverse.setOnClickListener{
            numbers.reverse()
            binding.textView.text = numbers.joinToString(separator = ", ")
        }

        binding.clear.setOnClickListener{
            numbers.clear()
            binding.textView.text = numbers.joinToString(separator = ", ")
        }

        binding.calculate.setOnClickListener{
            val numbersInt = numbers.mapNotNull { it.toIntOrNull() }
            suma = numbersInt.sum()
            count = numbersInt.size
            avg = if (count > 0) (suma.toDouble() / count).toInt() else 0
            Toast.makeText(this@MainActivity, "Count: {$count} - Sum: {$suma} - Avg: {$avg}", Toast.LENGTH_SHORT).show()
        }
    }

}