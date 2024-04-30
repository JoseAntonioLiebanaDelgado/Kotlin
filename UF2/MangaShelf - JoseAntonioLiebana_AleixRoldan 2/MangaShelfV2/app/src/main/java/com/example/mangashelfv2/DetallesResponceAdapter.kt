package com.example.mangashelfv2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// Adaptador para el RecyclerView que muestra detalles de manga
class DetallesResponceAdapter(val context: Context, val itemList: List<DetallesApiResponce>) :
    RecyclerView.Adapter<DetallesResponceAdapter.JsonViewHolder>() {

    // Clase ViewHolder para mantener las vistas de un elemento de la lista
    class JsonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre = itemView.findViewById<TextView>(R.id.nombreManga) // TextView para mostrar el nombre del manga
        val autor = itemView.findViewById<TextView>(R.id.autorManga) // TextView para mostrar el autor del manga
        val numVolumenes = itemView.findViewById<TextView>(R.id.numVolumenesManga) // TextView para mostrar el número de volúmenes del manga
        val editorial = itemView.findViewById<TextView>(R.id.editorialManga) // TextView para mostrar la editorial del manga
        val descripcion = itemView.findViewById<TextView>(R.id.descripcionManga) // TextView para mostrar la descripción del manga
        val imageURL = itemView.findViewById<ImageView>(R.id.imageView) // ImageView para mostrar la imagen del manga
    }

    // Método para crear nuevas instancias de ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JsonViewHolder {
        // Inflar el diseño del elemento de la lista
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.detalle_layout, parent, false)
        return JsonViewHolder(view) // Devolver un nuevo ViewHolder con la vista inflada
    }

    // Método para obtener el número total de elementos en la lista
    override fun getItemCount(): Int {
        return itemList.size
    }

    // Método para vincular datos a las vistas en un ViewHolder dado
    override fun onBindViewHolder(holder: JsonViewHolder, position: Int) {
        val item: DetallesApiResponce = itemList[position] // Obtener el objeto DetallesApiResponce en la posición actual
        val nombre = item.nombre.toString() // Obtener el nombre del manga como cadena
        val autor = item.autor.toString() // Obtener el autor del manga como cadena
        val numVolumenes = item.numVolumenes.toString() // Obtener el número de volúmenes del manga como cadena
        val editorial = item.editorial.toString() // Obtener la editorial del manga como cadena
        val descripcion = item.descripcion.toString() // Obtener la descripción del manga como cadena
        val imgURL = item.imgURL.toString() // Obtener la URL de la imagen del manga como cadena

        // Cargar la imagen del manga en el ImageView usando Glide
        Glide.with(context)
            .load(imgURL)
            .into(holder.imageURL) // Cargar la imagen en el ImageView

        holder.nombre.text = "$nombre" // Mostrar el nombre del manga en el TextView correspondiente
        holder.autor.text = "$autor" // Mostrar el autor del manga en el TextView correspondiente
        holder.numVolumenes.text = "Volumenes: $numVolumenes" // Mostrar el número de volúmenes del manga en el TextView correspondiente
        holder.editorial.text = "Editorial: $editorial" // Mostrar la editorial del manga en el TextView correspondiente
        holder.descripcion.text = "$descripcion" // Mostrar la descripción del manga en el TextView correspondiente
    }
}
