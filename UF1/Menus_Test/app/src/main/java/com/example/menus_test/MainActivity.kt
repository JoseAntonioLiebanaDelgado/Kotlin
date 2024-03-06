package com.example.menus_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.example.menus_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.option1 -> {
                Toast.makeText(this, "Option 1 seleccionado", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.option2 -> {
                Toast.makeText(this, "Option 2 seleccionado", Toast.LENGTH_SHORT).show()
                val aux = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                if (aux != null) {
                    supportFragmentManager.beginTransaction().remove(aux).commit()
                }
                return true
            }
            R.id.option3 -> {
                Toast.makeText(this, "Option 3 seleccionado", Toast.LENGTH_SHORT).show()
                supportFragmentManager.findFragmentById()
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainerView, FileFragment.newInstance("", ""))
                    .commit()

                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}