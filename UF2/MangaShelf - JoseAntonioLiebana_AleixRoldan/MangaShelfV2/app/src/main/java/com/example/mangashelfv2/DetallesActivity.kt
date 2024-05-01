package com.example.mangashelfv2

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mangashelfv2.API.JsonInterfaceObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Actividad para mostrar detalles de un manga específico
class DetallesActivity : AppCompatActivity() {

    lateinit var recyclerDetalleId : RecyclerView // RecyclerView para mostrar detalles
    lateinit var detalleIdAdapter : DetallesResponceAdapter // Adaptador para RecyclerView
    lateinit var text_ : TextView // TextView para mostrar información de detalle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalles_activity) // Establecer el diseño de la actividad desde XML

        recyclerDetalleId = findViewById(R.id.recyclerDetalles) // Inicializar RecyclerView desde XML
        recyclerDetalleId.setHasFixedSize(true) // Establecer tamaño fijo para mejorar rendimiento
        recyclerDetalleId.layoutManager = LinearLayoutManager(this) // Establecer diseño lineal para el RecyclerView

        getDetallesData() // Obtener y mostrar detalles del manga
    }

    // Método para obtener y mostrar detalles del manga
    private fun getDetallesData() {
        text_ = findViewById(R.id.comment) // Inicializar TextView desde XML

        val detalleId = intent.getStringExtra("id") // Obtener ID del manga de la actividad anterior
        val id = detalleId!!.toInt() // Convertir ID a entero

        // Obtener detalles del manga por su ID de forma asíncrona
        val getDetalle = JsonInterfaceObject.retrofit.getDetalleById(id, "id")
        getDetalle.enqueue(object : Callback<List<DetallesApiResponce>?> {
            // Manejar respuesta exitosa
            override fun onResponse(
                call: Call<List<DetallesApiResponce>?>,
                response: Response<List<DetallesApiResponce>?>
            ) {
                val response = response.body()!! // Obtener cuerpo de la respuesta
                detalleIdAdapter = DetallesResponceAdapter(this@DetallesActivity, response) // Crear adaptador con la respuesta
                detalleIdAdapter.notifyDataSetChanged() // Notificar cambios en el adaptador
                recyclerDetalleId.adapter = detalleIdAdapter // Establecer adaptador en el RecyclerView

                text_.text = "Detalle Manga con ID: $id" // Mostrar información de detalle en el TextView
            }

            // Manejar error en la solicitud
            override fun onFailure(call: Call<List<DetallesApiResponce>?>, t: Throwable) {
                // Mostrar mensaje de error utilizando Toast
                Toast.makeText(this@DetallesActivity, t.localizedMessage, Toast.LENGTH_LONG)
                    .show()
            }
        })
    }
}
