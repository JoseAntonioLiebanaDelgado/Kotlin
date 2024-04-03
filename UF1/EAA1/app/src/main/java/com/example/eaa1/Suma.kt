// Define el paquete en el que se encuentra esta clase.
package com.example.eaa1

// Importa la interfaz Serializable de Java, necesaria para que los objetos de esta clase puedan ser serializados.
import java.io.Serializable

// Declara la clase Suma con dos propiedades, operand1 y operand2, ambas del tipo Double.
// La clase implementa la interfaz Serializable, lo que permite que sus instancias puedan ser pasadas entre actividades en un Intent.
class Suma(val operand1: Double, val operand2: Double) : Serializable
