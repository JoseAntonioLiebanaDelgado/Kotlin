// Declara el paquete donde se encuentra el fragmento.
package com.example.ejercicio_autoevaluativo

// Importa las clases necesarias para trabajar con fragmentos y vistas en Android.
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// Define la clase HolaMundoFragment heredando de Fragment.
class HolaMundoFragment : Fragment() {
    // Sobreescribe el método onCreateView, que Android llama para pedir al fragmento que construya su interfaz de usuario.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el archivo XML asociado con el fragmento (fragment_hola_mundo.xml) y lo retorna.
        // El parámetro 'false' indica que no estamos añadiendo la vista inflada al contenedor todavía, ya que el sistema lo hará por nosotros.
        return inflater.inflate(R.layout.fragment_hola_mundo, container, false)
    }
}
