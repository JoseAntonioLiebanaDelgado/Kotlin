// Define el paquete al que pertenece esta clase.
package com.example.ejercicio_autoevaluativo

// Importa las clases necesarias de Android.
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio_autoevaluativo.databinding.ActivityMain2Binding

// Declara la clase MainActivity2 que hereda de AppCompatActivity, una subclase de Activity.
class MainActivity2 : AppCompatActivity() {
    // Crea una variable para el binding que se inicializará más tarde. Esta permite acceder a las vistas.
    private lateinit var binding: ActivityMain2Binding

    // onCreate es llamado cuando se crea la instancia de la Activity.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializa el binding para esta Activity.
        binding = ActivityMain2Binding.inflate(layoutInflater)
        // Establece la vista de la Activity utilizando la raíz del binding.
        setContentView(binding.root)

        // Intenta obtener un objeto Suma pasado desde MainActivity.
        val suma = intent.getSerializableExtra("suma") as? Suma
        // Si el objeto Suma no es nulo, utiliza 'let' para trabajar con el objeto no nulo.
        suma?.let {
            // Realiza la suma llamando al método sumar() y guarda el resultado.
            val resultado = it.sumar()
            // Establece el texto del TextView con el resultado de la suma.
            binding.textViewResult.text = resultado.toString()
        }

        // Establece un listener para el botón Reset.
        binding.buttonReset.setOnClickListener {
            // Al hacer clic en Reset, finaliza esta Activity y vuelve a la anterior en la pila.
            finish()
        }
    }
}
