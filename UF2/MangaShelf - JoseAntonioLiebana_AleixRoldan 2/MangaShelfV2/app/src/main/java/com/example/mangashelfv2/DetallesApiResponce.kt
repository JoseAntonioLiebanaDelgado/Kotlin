package com.example.mangashelfv2

// Definición de la clase de datos DetallesApiResponce para representar detalles de un manga
data class DetallesApiResponce(
    val id: Int, // Propiedad que almacena el ID del manga como un entero
    val nombre: String, // Propiedad que almacena el nombre del manga como una cadena de texto
    val numVolumenes: Int, // Propiedad que almacena el número de volúmenes del manga como un entero
    val autor: String, // Propiedad que almacena el autor del manga como una cadena de texto
    val editorial: String, // Propiedad que almacena la editorial del manga como una cadena de texto
    val descripcion: String, // Propiedad que almacena la descripción del manga como una cadena de texto
    val imgURL: String // Propiedad que almacena la URL de la imagen del manga como una cadena de texto
)
