package com.example.mangashelfv2.GetById

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mangashelfv2.API.JsonInterfaceObject
import com.example.mangashelfv2.DetallesApiResponce
import com.example.mangashelfv2.DetallesResponceAdapter
import com.example.mangashelfv2.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Actividad para mostrar detalles de un manga por su ID
class DetallesByIdActivity : AppCompatActivity() {

    lateinit var detallesResponceIdAdapter: DetallesResponceAdapter // Adaptador para RecyclerView
    lateinit var mangaHeadingView: TextView // TextView para mostrar información del manga

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga_by_id) // Establecer el diseño de la actividad desde XML

        val toolbar: Toolbar = findViewById(R.id.toolbar) // Inicializar Toolbar desde XML
        setSupportActionBar(toolbar) // Configurar Toolbar como la barra de herramientas de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Habilitar el botón de navegación hacia atrás en la ActionBar

        mangaHeadingView = findViewById(R.id.detallesHeadingView) // Inicializar TextView desde XML

        val btnLink: Button = findViewById(R.id.btn_link) // Inicializar botón desde XML
        btnLink.setOnClickListener {
            openLink() // Configurar clic para abrir un enlace en el navegador
        }

        getDetallesById() // Obtener y mostrar detalles del manga por su ID
    }

    // Función para abrir el enlace en el navegador
    private fun openLink() {
        val url = "https://www.normacomics.com/comics/manga.html" // Enlace que deseas abrir
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    // Manejar el clic en el botón de navegación hacia atrás
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    // Método para obtener y mostrar detalles del manga por su ID
    private fun getDetallesById() {
        val recyclerMangaId = findViewById<RecyclerView>(R.id.recycler_detalles_by_id) // Inicializar RecyclerView desde XML
        recyclerMangaId.setHasFixedSize(true) // Establecer tamaño fijo para mejorar rendimiento
        recyclerMangaId.layoutManager = LinearLayoutManager(this) // Establecer diseño lineal para el RecyclerView

        val userId = intent.getStringExtra("id") // Obtener ID del manga de la actividad anterior
        val id = userId!!.toInt() // Convertir ID a entero
        supportActionBar?.title = "Manga con ID: $id" // Establecer título de la barra de herramientas

        // Obtener detalles del manga por su ID de forma asíncrona
        val detalleById = JsonInterfaceObject.retrofit.getDetalleById(id,"id")
        detalleById.enqueue(object : Callback<List<DetallesApiResponce>?> {
            // Manejar respuesta exitosa
            override fun onResponse(
                call: Call<List<DetallesApiResponce>?>,
                response: Response<List<DetallesApiResponce>?>
            ) {
                // Crear adaptador con la respuesta y configurar RecyclerView
                detallesResponceIdAdapter = DetallesResponceAdapter(this@DetallesByIdActivity,response.body()!!)
                detallesResponceIdAdapter.notifyDataSetChanged()
                recyclerMangaId.adapter = detallesResponceIdAdapter
            }

            // Manejar error en la solicitud
            override fun onFailure(call: Call<List<DetallesApiResponce>?>, t: Throwable) {
                // Mostrar mensaje de error utilizando Toast
                Toast.makeText(this@DetallesByIdActivity,t.localizedMessage, Toast.LENGTH_LONG)
                    .show()
            }
        })
    }
}
