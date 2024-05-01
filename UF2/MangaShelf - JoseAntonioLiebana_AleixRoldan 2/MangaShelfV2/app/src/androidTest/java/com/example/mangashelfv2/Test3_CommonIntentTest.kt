package com.example.mangashelfv2

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mangashelfv2.GetById.DetallesByIdActivity
import androidx.test.espresso.intent.matcher.IntentMatchers
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Test3_CommonIntentTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule(DetallesByIdActivity::class.java, true, false)

    // Este test verifica que el Intent para comprar manga funciona correctamente.
    // Prepara el Intent con un ID de manga válido, lanza la actividad y simula un clic en el botón de comprar manga.
    // Luego verifica que el Intent correcto (con acción VIEW y la URL correcta) se haya lanzado.
    @Test
    fun testBuyMangaIntent() {
        // Preparar el Intent con datos necesarios si fuera el caso
        val intent = Intent(ApplicationProvider.getApplicationContext(), DetallesByIdActivity::class.java).apply {
            putExtra("id", "2") // Asumimos que "2" es un ID válido que necesita pasar a la actividad
        }

        // Lanzar la actividad con el intent preparado
        intentsTestRule.launchActivity(intent)

        // Realizar clic en el botón de comprar manga
        onView(withId(R.id.btn_link)).perform(click())

        // Verificar que se ha lanzado un intent con la acción VIEW y los datos (la URL) adecuados
        intended(allOf(
            IntentMatchers.hasAction(Intent.ACTION_VIEW),
            IntentMatchers.hasData("https://www.normacomics.com/comics/manga.html")  // Asegúrate de que esta sea la URL a la que se debe dirigir
        ))
    }
}
