package com.example.ejercicio_autoevaluativo // Asegúrate de cambiar esto por el nombre de tu paquete real

import java.io.Serializable

class Suma(
    val operand1: Double,
    val operand2: Double
) : Serializable {
    // Si necesitas que la clase realice la operación de suma, podrías añadir una función aquí.
    fun sumar(): Double {
        return operand1 + operand2
    }
}
