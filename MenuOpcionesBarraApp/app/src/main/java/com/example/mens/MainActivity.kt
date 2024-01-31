package com.example.mens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onMenuItemClick(item)
        return super.onOptionsItemSelected(item)
    }

    private fun onMenuItemClick(item: MenuItem) {
        when (item.itemId) {
            R.id.item1 -> showToast("Opción 1 seleccionada")
            R.id.item2 -> showToast("Opción 2 seleccionada")
            R.id.item3 -> {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainerView, BlankFragment.newInstance("", ""))
                    .commit()
            }
            else -> showToast("Opción no reconocida")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
