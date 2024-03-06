package com.example.mangashelf

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleMangaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_manga)

        val imageViewManga: ImageView = findViewById(R.id.imageViewManga)
        val textViewMangaName: TextView = findViewById(R.id.textViewMangaName)

        // Get the manga ID from the intent
        val mangaId = intent.getIntExtra("mangaId", 0)

        // You can replace this logic with your actual manga data retrieval
        val manga = getMangaDetailsById(mangaId)

        // Display manga details
        imageViewManga.setImageResource(manga.imageResourceId)
        textViewMangaName.text = manga.name
    }

    // Replace this function with your actual manga data retrieval logic
    private fun getMangaDetailsById(mangaId: Int): Manga {
        // Dummy data for illustration purposes
        return when (mangaId) {
            1 -> Manga("Manga 1", R.drawable.manga1)
            2 -> Manga("Manga 2", R.drawable.manga2)
            // Add more cases as needed
            else -> Manga("Unknown Manga", R.drawable.manga1)
        }
    }

    data class Manga(val name: String, val imageResourceId: Int)
}
