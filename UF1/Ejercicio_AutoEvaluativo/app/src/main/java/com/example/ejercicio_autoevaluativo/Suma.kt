// Declara el paquete donde reside la clase, que debe coincidir con la estructura de directorios de tu proyecto.
package com.example.ejercicio_autoevaluativo

// Importa la interfaz Serializable de Java, lo que permite que objetos de esta clase puedan ser serializados.
import java.io.Serializable

// Define la clase Suma, que toma dos operandos de tipo Double como parámetros y los almacena como propiedades.
class Suma(
    val operand1: Double, // La propiedad 'operand1' almacena el primer número para la suma.
    val operand2: Double  // La propiedad 'operand2' almacena el segundo número para la suma.
) : Serializable { // La clase implementa Serializable, lo cual es requerido para pasar instancias a través de Intents.

    // Define una función 'sumar' que no toma argumentos y devuelve la suma de 'operand1' y 'operand2'.
    fun sumar(): Double {
        return operand1 + operand2 // Devuelve el resultado de sumar las dos propiedades.
    }
}
