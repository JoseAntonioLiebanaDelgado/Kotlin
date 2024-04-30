package com.example.mangashelfv2.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Objeto para obtener una instancia de Retrofit y la interfaz JsonInterface
object JsonInterfaceObject {
    // Inicializar Retrofit con la URL base y el convertidor Gson
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create()) // Usar Gson para convertir JSON a objetos
        .baseUrl("https://my-json-server.typicode.com/aroldangarcia/BBDD_MangaShelf/") // URL base de la API
        .build()
        .create(JsonInterface::class.java) // Crear una instancia de la interfaz JsonInterface para realizar llamadas a la API
}
