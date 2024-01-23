package com.example.recyclerview_aleixroldan_joseantonio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val contactosList = mutableListOf<Contacto>()
    private val adapter = ContactosAdapter(contactosList)
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val agregarButton = findViewById<Button>(R.id.agregarButton)
        agregarButton.setOnClickListener {
            agregarContacto()
        }
    }

    private fun agregarContacto() {
        val nombreEditText = findViewById<EditText>(R.id.nombreEditText)
        val telefonoEditText = findViewById<EditText>(R.id.telefonoEditText)

        val nombre = nombreEditText.text.toString()
        val telefono = telefonoEditText.text.toString()

        if (nombre.isNotEmpty() && telefono.isNotEmpty()) {
            contactosList.add(Contacto(nombre, telefono))
            adapter.notifyDataSetChanged()

            nombreEditText.text.clear()
            telefonoEditText.text.clear()
        }
    }

    fun verDetallesClick(view: View) {
        val holder = recyclerView.getChildViewHolder(view)
        val position = holder.adapterPosition

        if (position != RecyclerView.NO_POSITION) {
            val contacto = contactosList[position]

            val intent = Intent(this, DetallesActivity::class.java)
            intent.putExtra("contacto", contacto)
            startActivity(intent)
        }
    }

}



