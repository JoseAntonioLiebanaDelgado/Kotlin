package com.example.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val items: MutableList<Product>, val context: Context): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    //On fem les crides i vinvulem la info dels elements amb les vistes
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val intent = Intent(context, ClientView::class.java)
        val item = items[position]
        holder.tvItem.text = item.quantity.toString() + "x " + item.name

        holder.delete.setOnClickListener{
            items.removeAt(position)
            notifyDataSetChanged()
        }
        holder.tvItem.setOnClickListener{
            intent.putExtra("EXTRA_TEXT", Product(item.name, item.quantity))
            context.startActivity(intent)
        }

        holder.check.setOnClickListener{
            val checkImageButton = holder.check
            if (checkImageButton.tag == null || checkImageButton.tag == "off") {
                checkImageButton.setImageResource(android.R.drawable.checkbox_on_background)
                checkImageButton.tag = "on"
            } else {
                checkImageButton.setImageResource(android.R.drawable.checkbox_off_background)
                checkImageButton.tag = "off"
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //Classe que representa cada item
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvItem = view.findViewById<TextView>(R.id.tv_item)
        val delete = view.findViewById<ImageButton>(R.id.delete)
        val check = view.findViewById<ImageButton>(R.id.check)
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
        fun onDeleteClick(position: Int)
    }
}