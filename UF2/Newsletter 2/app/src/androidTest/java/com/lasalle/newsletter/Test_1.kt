package com.lasalle.newsletter

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Test_1 {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testEmptyFieldsDoNotAdvance() {

        onView(withId(R.id.bt_signup)).perform(click())
        onView(withText(R.string.error)).check(matches(withText("Error, nombre y correo son necesarios")))
    }

    @Test
    fun testNonEmptyFieldsAdvance() {

        onView(withId(R.id.et_name)).perform(typeText("Pepe"))
        onView(withId(R.id.et_email)).perform(typeText("Pepe@example.com"))
        onView(withId(R.id.bt_signup)).perform(click())

        onView(withId(R.id.fcv_second)).check(matches(isDisplayed()))
    }
}

/**
 * 1. Configuramos el entorno del test, incluyendo el estado inicial de la app.
 *
 * 2. Interaccionamos con la interfaz del usuario mediante acciones como clics, entradas de texto, etc..
 *
 * 3. Por ultimo comprobamos que la interfaz de usuario refleje el estado que esperamos tras las acciones.
 */
