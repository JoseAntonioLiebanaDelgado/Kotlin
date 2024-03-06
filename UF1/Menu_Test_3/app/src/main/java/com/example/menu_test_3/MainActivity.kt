package com.example.menu_test_3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import com.example.menu_test_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonShowPopup: Button = findViewById(R.id.button_show_popup)
        buttonShowPopup.setOnClickListener { view ->
            showPopupMenu(view)
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        val result = Integer.parseInt(binding.result.text.toString())
        popupMenu.inflate(R.menu.pop_up_menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_option_1 -> {
                    binding.result.text = (result + 1).toString()
                    true
                }
                R.id.menu_option_2 -> {
                    binding.result.text = (result + 2).toString()
                    true
                }
                R.id.menu_option_3 -> {
                    binding.result.text = (result + 3).toString()
                    true
                }
                R.id.menu_option_4 -> {
                    binding.result.text = (result + 3333).toString()
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}