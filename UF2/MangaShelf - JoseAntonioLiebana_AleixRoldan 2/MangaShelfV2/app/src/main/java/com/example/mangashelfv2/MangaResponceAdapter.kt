package com.example.mangashelfv2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// Adaptador para el RecyclerView que muestra la lista de respuestas de manga
class MangaResponceAdapter(val context: Context, val itemList: List<MangaApiResponce>) :
    RecyclerView.Adapter<MangaResponceAdapter.JsonViewHolder>() {

    // Clase ViewHolder para mantener las vistas de un elemento de la lista
    class JsonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id = itemView.findViewById<TextView>(R.id.id) // TextView para mostrar el ID del manga
        val imageURL = itemView.findViewById<ImageView>(R.id.imageView) // ImageView para mostrar la imagen del manga
    }

    // Método para crear nuevas instancias de ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JsonViewHolder {
        // Inflar el diseño del elemento de la lista
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.json_layout, parent, false)
        return JsonViewHolder(view) // Devolver un nuevo ViewHolder con la vista inflada
    }

    // Método para obtener el número total de elementos en la lista
    override fun getItemCount(): Int {
        return itemList.size
    }

    // Método para vincular datos a las vistas en un ViewHolder dado
    override fun onBindViewHolder(holder: JsonViewHolder, position: Int) {
        val item: MangaApiResponce = itemList[position] // Obtener el objeto MangaApiResponce en la posición actual
        val id = item.id.toString() // Obtener el ID del manga como string
        val imgURL = item.imgURL.toString() // Obtener la URL de la imagen del manga como string

        // Cargar la imagen del manga en el ImageView usando Glide
        Glide.with(context)
            .load(imgURL)
            .into(holder.imageURL) // Cargar la imagen en el ImageView

        holder.id.text = "Manga ID: $id" // Mostrar el ID del manga en el TextView
    }
}
