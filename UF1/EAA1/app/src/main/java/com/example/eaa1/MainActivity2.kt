// Define el paquete en el que se encuentra esta clase.
package com.example.eaa1

// Importaciones necesarias para utilizar clases y funciones de Android.
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

// Declara la clase MainActivity2 que hereda de AppCompatActivity, que es una subclase básica para actividades.
class MainActivity2 : AppCompatActivity() {

    // Sobrescribe el método onCreate, que es llamado cuando se crea la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama a la implementación del padre.
        setContentView(R.layout.activity_main2) // Establece el diseño de la actividad utilizando el archivo XML especificado.

        // Recupera el objeto Suma pasado desde MainActivity.
        val suma = intent.getSerializableExtra("suma") as Suma
        // Calcula el resultado sumando los operandos del objeto Suma.
        val resultat = suma.operand1 + suma.operand2
        // Encuentra el TextView por su ID y establece el texto con el resultado de la suma.
        findViewById<TextView>(R.id.textResult).text = resultat.toString()

        // Encuentra el botón por su ID y establece un listener para el evento de clic.
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            // Crea una nueva intención para iniciar MainActivity.
            val intent = Intent(this, MainActivity::class.java)
            // Inicia la actividad especificada en la intención.
            startActivity(intent)
            // Finaliza la actividad actual para volver a MainActivity.
            finish()
        }
    }
}
