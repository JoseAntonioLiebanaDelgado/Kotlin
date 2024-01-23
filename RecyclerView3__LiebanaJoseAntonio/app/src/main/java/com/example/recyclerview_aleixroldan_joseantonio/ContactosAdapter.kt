package com.example.recyclerview_aleixroldan_joseantonio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactosAdapter(private val contactos: List<Contacto>) :
    RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto = contactos[position]
        holder.nombreTextView.text = contacto.nombre

        holder.verDetallesButton.setOnClickListener {
            (holder.itemView.context as MainActivity).verDetallesClick(holder.itemView)
        }
    }

    override fun getItemCount(): Int {
        return contactos.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        val verDetallesButton: ImageButton = itemView.findViewById(R.id.verDetallesButton)
    }
}

