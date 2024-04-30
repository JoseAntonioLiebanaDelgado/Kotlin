package com.example.mangashelfv2

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class Test2_ElementsPositionTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    //Este test verifica que el EditText para el ID del manga (mangaId) esté presente en la pantalla y sea visible para el usuario.
    //Esto significa que el elemento no solo está presente en el layout de la actividad sino que también está renderizado y no oculto por otro elemento de la interfaz.
    @Test
    fun checkEditTextIsDisplayed() {
        onView(withId(R.id.mangaId))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    //Este test asegura que el botón de búsqueda (btnId) sea visible en la pantalla cuando se inicia MainActivity.
    // Como con el EditText, este test confirma que el botón no solo está en el árbol de vistas de la actividad sino que también es visible para el usuario.
    @Test
    fun checkSearchButtonIsDisplayed() {
        onView(withId(R.id.btnId))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}

