package com.example.mangashelfv2

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Test1_NavigationTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Verifica que la navegación a DetallesByIdActivity sea exitosa al introducir un ID válido
    @Test
    fun testNavigationToDetailsById() {
        // Introducir un ID en el EditText
        onView(withId(R.id.mangaId)).perform(typeText("1"))
        // Simular el clic en el botón para obtener los detalles
        onView(withId(R.id.btnId)).perform(click())
        // Comprobar que el TextView con el ID "detallesHeadingView" está en la pantalla, lo que implica que la navegación ha sido exitosa
        onView(withId(R.id.detallesHeadingView)).check(matches(isDisplayed()))
    }

    // Verifica que no se realiza la navegación si el campo ID está vacío
    @Test
    fun testNoNavigationIfIdIsEmpty() {
        // Dejar el EditText vacío
        // Simular el clic en el botón para obtener los detalles
        onView(withId(R.id.btnId)).perform(click())
        // Comprobar que permanecemos en la MainActivity y que la DetallesByIdActivity no se ha lanzado
        onView(withId(R.id.btnId)).check(matches(isDisplayed())) // Se comprueba que el EditText sigue presente
    }

    // // Verifica que aparece un Toast con un mensaje de error si no se ha introducido un ID
    // @Test
    // fun testToastAppearsIfIdIsEmpty() {
    //     // Intentamos navegar sin introducir un ID
    //     onView(withId(R.id.btnId)).perform(click())

    //     // Verificar que el Toast con el mensaje correcto se muestra
    //     onView(withText("No se ha añadido ningún ID de manga")).check(matches(isDisplayed()))
    // }
}
