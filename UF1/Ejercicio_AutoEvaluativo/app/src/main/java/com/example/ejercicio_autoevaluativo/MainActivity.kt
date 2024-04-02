// Define el paquete al que pertenece esta clase de actividad.
package com.example.ejercicio_autoevaluativo

// Importa las clases necesarias de Android y de tu proyecto.
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio_autoevaluativo.databinding.ActivityMainBinding

// Declara tu MainActivity que hereda de AppCompatActivity, lo cual le da soporte de ActionBar y más.
class MainActivity : AppCompatActivity() {
    // Declara una variable para el binding. El binding te permite acceder a las vistas en el layout asociado con esta actividad.
    private lateinit var binding: ActivityMainBinding

    // onCreate es un método del ciclo de vida de la actividad que se llama cuando la actividad está siendo creada.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializa el binding para esta actividad. Esto "infla" el layout y prepara las vistas para ser accesadas.
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Establece la vista de la actividad usando la raíz del binding.
        setContentView(binding.root)

        // Evento de clic para el botón Suma. Define lo que sucede cuando se hace clic en el botón.
        binding.buttonSuma.setOnClickListener {
            // Recupera el texto de los EditText, lo convierte a Double o devuelve null si está vacío o es inválido.
            val operand1 = binding.editTextNumberDecimal1.text.toString().toDoubleOrNull()
            val operand2 = binding.editTextNumberDecimal2.text.toString().toDoubleOrNull()

            // Verifica si ambos operandos no son nulos (es decir, son números válidos).
            if (operand1 != null && operand2 != null) {
                // Crea una instancia de la clase Suma y realiza la operación sumar.
                val suma = Suma(operand1, operand2)
                // Muestra un Toast con el resultado de la suma.
                Toast.makeText(this, "Resultado: ${suma.sumar()}", Toast.LENGTH_SHORT).show()
            } else {
                // Si uno o ambos operandos son nulos, muestra un Toast pidiendo al usuario que ingrese ambos números.
                Toast.makeText(this, "Por favor, ingrese ambos números.", Toast.LENGTH_SHORT).show()
            }
        }

        // Evento de clic para el botón Toast. Define lo que sucede cuando se hace clic en este botón.
        binding.buttonToast.setOnClickListener {
            // Muestra un Toast con el texto "Aparece Toast!".
            Toast.makeText(this, "Aparece Toast!", Toast.LENGTH_SHORT).show()
        }

        // Evento de clic para el botón que muestra el fragmento HolaMundo.
        binding.buttonShowFragment.setOnClickListener {
            // Crea una nueva instancia de HolaMundoFragment.
            val fragment = HolaMundoFragment()
            // Inicia una transacción de fragmentos, reemplaza cualquier contenido en el contenedor de fragmentos con HolaMundoFragment.
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fragment)
                // Agrega la transacción al back stack, permitiendo al usuario volver atrás con el botón de retroceso.
                addToBackStack(null)
                // Realiza la transacción.
                commit()
            }
        }
    }
}
