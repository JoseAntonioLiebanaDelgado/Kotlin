// Define el paquete en el que se encuentra esta clase.
package com.example.eaa1

// Importaciones necesarias para utilizar clases y funciones de Android.
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

// Declara la clase MainActivity que hereda de AppCompatActivity, que es una subclase básica para actividades.
class MainActivity : AppCompatActivity() {

    // Sobrescribe el método onCreate, que es llamado cuando se crea la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama a la implementación del padre.
        setContentView(R.layout.activity_main) // Establece el diseño de la actividad utilizando el archivo XML especificado.

        // Encuentra el botón por su ID y establece un listener para el evento de clic.
        findViewById<Button>(R.id.buttonSuma).setOnClickListener{
            // Obtiene el primer operando desde el campo de texto, lo convierte a Double o usa 0.0 si es nulo o no es un número.
            val operand1 =  findViewById<TextView>(R.id.inputText1).text.toString().toDoubleOrNull() ?: 0.0
            // Obtiene el segundo operando de manera similar al primero.
            val operand2 =  findViewById<TextView>(R.id.inputText2).text.toString().toDoubleOrNull() ?: 0.0
            // Realiza la operación de suma con los operandos.
            val suma = Suma(operand1, operand2)

            // Crea una nueva intención para iniciar MainActivity2.
            val intent = Intent(this, MainActivity2::class.java)
            // Adjunta el resultado de la suma a la intención.
            intent.putExtra("suma", suma)
            // Inicia la actividad especificada en la intención.
            startActivity(intent)
        }
    }
}
