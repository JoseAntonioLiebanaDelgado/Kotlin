package com.example.mangashelfv2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mangashelfv2.API.JsonInterfaceObject
import com.example.mangashelfv2.GetById.DetallesByIdActivity
import com.example.mangashelfv2.ROOM.AppDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase // Base de datos de la aplicación (ROOM)
    lateinit var mangaIdEdit : EditText // Campo de texto para ingresar ID de manga
    lateinit var getBtn : Button // Botón para obtener detalles del manga
    lateinit var body : TextView // TextView para mostrar información del manga
    lateinit var mangaResponceAdapter : MangaResponceAdapter // Adaptador para RecyclerView
    lateinit var recyclerManga : RecyclerView // RecyclerView para mostrar lista de mangas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga)

        /** ROOM IMPLEMENTATION
         *  No se ha podido implementar de estable y controlada, asi que se ha optado por dejar comentado.
         *  LOS ARCHIVOS ROOM ESTÁN EN EL PACKAGE "ROOM".
         *
         * GlobalScope.launch {
            db = AppDatabase.getInstance(applicationContext)!!

            val mangas = db.MangaDAO().loadAllMangas()

            mangas.forEach {
                Log.i("-->", it.toString())
            }
        } **/

        // Inicialización de elementos de la interfaz de usuario
        mangaIdEdit = findViewById(R.id.mangaId)
        getBtn = findViewById(R.id.btnId)

        // Configuración del clic del botón para obtener detalles del manga por ID
        getBtn.setOnClickListener {
            val mangaId = mangaIdEdit.text.toString()
            if (mangaId.isBlank()) {
                Toast.makeText(this, "No se ha añadido ningún ID de manga", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@MainActivity, DetallesByIdActivity::class.java)
                intent.putExtra("id", mangaId)
                startActivity(intent)
            }
        }


        // Configuración del RecyclerView
        recyclerManga = findViewById(R.id.recyclerManga)
        recyclerManga.setHasFixedSize(true)
        recyclerManga.layoutManager = LinearLayoutManager(this)

        // LLamada a método para obtener datos de manga y mostrarlos en el RecyclerView
        getMangaData()
    }

    // Método privado para obtener datos de manga utilizando Retrofit
    private fun getMangaData() {
        // Obtener datos de manga de forma asíncrona
        val data = JsonInterfaceObject.retrofit.getManga()
        data.enqueue(object : Callback<List<MangaApiResponce>?> {
            // Manejar respuesta exitosa
            override fun onResponse(
                call: Call<List<MangaApiResponce>?>,
                response: Response<List<MangaApiResponce>?>
            ) {
                val responce = response.body()!! // Obtener cuerpo de la respuesta

                // Configurar y actualizar adaptador del RecyclerView
                mangaResponceAdapter = MangaResponceAdapter(this@MainActivity,responce)
                mangaResponceAdapter.notifyDataSetChanged()
                recyclerManga.adapter = mangaResponceAdapter
            }
            // Manejar error en la solicitud
            override fun onFailure(call: Call<List<MangaApiResponce>?>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.localizedMessage,Toast.LENGTH_LONG)
                    .show()
            }
        })
    }
}