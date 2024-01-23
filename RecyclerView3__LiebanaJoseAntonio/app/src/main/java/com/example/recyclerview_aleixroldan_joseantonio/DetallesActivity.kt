package com.example.recyclerview_aleixroldan_joseantonio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetallesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)
        
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val contacto = intent.getSerializableExtra("contacto") as Contacto
        val detallesRecyclerView = findViewById<RecyclerView>(R.id.detallesRecyclerView)
        detallesRecyclerView.layoutManager = LinearLayoutManager(this)
        val detallesAdapter = DetallesAdapter(listOf(contacto))
        detallesRecyclerView.adapter = detallesAdapter
    }

    // Manejar el clic en el botón de navegación hacia atrás
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}


