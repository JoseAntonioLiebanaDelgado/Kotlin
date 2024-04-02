// Paquete en el que se encuentra la clase MainActivity2.
package com.example.ejercicio_autoevaluativo

// Importa las clases necesarias de la biblioteca de Android y la clase de binding generada para activity_main2.xml.
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio_autoevaluativo.databinding.ActivityMain2Binding

// MainActivity2 hereda de AppCompatActivity, lo que le proporciona soporte para características más recientes en versiones antiguas de Android.
class MainActivity2 : AppCompatActivity() {
    // Define una propiedad 'binding' que se inicializará más tarde, permitiendo acceder a las vistas definidas en el archivo XML de manera segura.
    private lateinit var binding: ActivityMain2Binding

    // onCreate es un método del ciclo de vida de la actividad que se invoca cuando la actividad se está creando.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializa la propiedad 'binding' inflando el layout correspondiente a esta actividad.
        binding = ActivityMain2Binding.inflate(layoutInflater)
        // Establece el contenido de la actividad a la vista raíz del binding.
        setContentView(binding.root)

        // Recupera el objeto 'Suma' que fue pasado como extra desde MainActivity mediante un Intent.
        val suma = intent.getSerializableExtra("suma") as? Suma
        // Verifica si el objeto 'suma' no es nulo y, si es así, ejecuta el bloque de código dentro de 'let'.
        suma?.let {
            // Llama al método 'sumar' del objeto 'Suma' y almacena el resultado en una variable.
            val resultado = it.sumar()
            // Actualiza el TextView definido en el XML con el resultado de la suma.
            binding.textViewResult.text = resultado.toString()
        }

        // Define un listener para el botón 'Reset'. Este listener escucha los eventos de clic en ese botón.
        binding.buttonReset.setOnClickListener {
            // Cierra esta actividad y regresa a la anterior en el stack de actividades al hacer clic en el botón.
            finish()
        }
    }
}
