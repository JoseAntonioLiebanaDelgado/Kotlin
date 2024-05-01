package com.example.mangashelfv2.API

import com.example.mangashelfv2.DetallesApiResponce
import com.example.mangashelfv2.MangaApiResponce
import retrofit2.Call
import retrofit2.http.*

// Interfaz para definir las llamadas a la API utilizando Retrofit
interface JsonInterface {
    // Obtener la lista de mangas desde la API
    @GET("mangas")
    fun getManga() : Call<List<MangaApiResponce>>

    // Obtener un manga por su ID y ordenarlo según el criterio especificado
    @GET("mangas")
    fun getMangaById(
        @Query("id") id: Int,
        @Query("_sort") sort : String,
    ) : Call<List<MangaApiResponce>>

    // Obtener detalles de un manga por su ID y ordenarlo según el criterio especificado
    @GET("mangas")
    fun getDetalleById(
        @Query("id") id: Int,
        @Query("_sort") sort : String,
    ) : Call<List<DetallesApiResponce>>

    // Enviar datos de manga a la API mediante POST
    @POST("mangas")
    fun mangaData(
        @Body mangas : DetallesApiResponce
    ) : Call<MangaApiResponce>

    // Actualizar datos de manga mediante PATCH utilizando su nombre
    @PATCH("mangas/{nombre}")
    fun patchManga(@Path("nombre") nombre: String, @Body mangaApiResponce: MangaApiResponce):Call<MangaApiResponce>

    // Eliminar manga mediante DELETE utilizando su nombre
    @DELETE("mangas/{nombre}")
    fun deleteManga(@Path("nombre") nombre:String) : Call<MangaApiResponce>
}
