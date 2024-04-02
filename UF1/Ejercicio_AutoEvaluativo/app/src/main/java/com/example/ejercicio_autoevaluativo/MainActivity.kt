package com.example.ejercicio_autoevaluativo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio_autoevaluativo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Manejador del evento de clic para el botón Suma
        binding.buttonSuma.setOnClickListener {
            val operand1 = binding.editTextNumberDecimal1.text.toString().toDoubleOrNull()
            val operand2 = binding.editTextNumberDecimal2.text.toString().toDoubleOrNull()

            if (operand1 != null && operand2 != null) {
                val suma = Suma(operand1, operand2)
                val intent = Intent(this, MainActivity2::class.java).apply {
                    putExtra("suma", suma)
                }
                startActivity(intent)
            } else {
                // Notificar al usuario que ambos números deben ser ingresados
                Toast.makeText(this, "Por favor, ingrese ambos números.", Toast.LENGTH_SHORT).show()
            }
        }

        // Manejador del evento de clic para el botón Toast
        binding.buttonToast.setOnClickListener {
            Toast.makeText(this, "Aparece Toast!", Toast.LENGTH_SHORT).show()
        }
    }
}
