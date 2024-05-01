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

    // Verifica que el EditText para el ID del manga (mangaId) esté presente y visible para el usuario.
    @Test
    fun checkEditTextIsDisplayed() {
        onView(withId(R.id.mangaId))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    // Asegura que el botón de búsqueda (btnId) sea visible cuando se inicia MainActivity.
    @Test
    fun checkSearchButtonIsDisplayed() {
        onView(withId(R.id.btnId))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}
