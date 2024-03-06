package com.example.mangashelf.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mangashelf.DetalleMangaActivity
import com.example.mangashelf.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Establecer OnClickListener para cada ImageView en el diseño
        for (i in 0 until binding.novedadesLayout.childCount) {
            val linearLayout: View = binding.novedadesLayout.getChildAt(i)
            linearLayout.setOnClickListener {
                openDetalleMangaActivity(it)  // Cambiado a 'it'
            }
        }

        for (i in 0 until binding.shonenLayout.childCount) {
            val linearLayout: View = binding.shonenLayout.getChildAt(i)
            linearLayout.setOnClickListener {
                openDetalleMangaActivity(it)
            }
        }

        // Buttons #1
        binding.buttonFav1.setOnClickListener {
            showToast("Mushoku Tensei #12 Favorito")
        }
        binding.buttonLeido1.setOnClickListener {
            showToast("Mushoku Tensei #12 Leido")
        }

        // Buttons #2
        binding.buttonFav2.setOnClickListener {
            showToast("Blue Lock #12 Favorito")
        }
        binding.buttonLeido2.setOnClickListener {
            showToast("Blue Lock #12 Leido")
        }

        // Buttons #3
        binding.buttonFav3.setOnClickListener {
            showToast("Oshi no Ko #4 Favorito")
        }
        binding.buttonLeido3.setOnClickListener {
            showToast("Oshi no Ko #4 Leido")
        }

        // Buttons #4
        binding.buttonFav4.setOnClickListener {
            showToast("Maximum Berserk #1 Favorito")
        }
        binding.buttonLeido4.setOnClickListener {
            showToast("Maximum Berserk #1 Leido")
        }

        // Buttons #5
        binding.buttonFav5.setOnClickListener {
            showToast("Vagabond #1 Favorito")
        }
        binding.buttonLeido5.setOnClickListener {
            showToast("Vagabond #1 Leido")
        }

        // Buttons #6
        binding.buttonFav6.setOnClickListener {
            showToast("Boy's Abyss #10 Favorito")
        }
        binding.buttonLeido6.setOnClickListener {
            showToast("Boy's Abyss #10 Leido")
        }

        // Buttons #7
        binding.buttonFav7.setOnClickListener {
            showToast("Evangelion #1 Favorito")
        }
        binding.buttonLeido7.setOnClickListener {
            showToast("Evangelion #1 Leido")
        }

        // Buttons #8
        binding.buttonFav8.setOnClickListener {
            showToast("Chainsaw Man #9 Favorito")
        }
        binding.buttonLeido8.setOnClickListener {
            showToast("Chainsaw Man #9 Leido")
        }

        // Buttons #9
        binding.buttonFav9.setOnClickListener {
            showToast("Ataque a los titanes #33 Favorito")
        }
        binding.buttonLeido9.setOnClickListener {
            showToast("Ataque a los titanes #33 Leido")
        }

        // Buttons #10
        binding.buttonFav10.setOnClickListener {
            showToast("OnePunchMan #8 Favorito")
        }
        binding.buttonLeido10.setOnClickListener {
            showToast("OnePunchMan #8 Leido")
        }

        return root
    }

    // Función para abrir la actividad de detalles del manga
    fun openDetalleMangaActivity(view: View) {
        val intent = Intent(requireContext(), DetalleMangaActivity::class.java)
        intent.putExtra("mangaId", getMangaIdByLinearLayout(view))
        startActivity(intent)
    }

    // Función para obtener el ID del manga desde la etiqueta del LinearLayout
    private fun getMangaIdByLinearLayout(linearLayout: View): Int {
        val mangaIdString = linearLayout.tag?.toString()
        return mangaIdString?.toIntOrNull() ?: 0
    }

    // Función para mostrar un Toast con un mensaje personalizado
    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

