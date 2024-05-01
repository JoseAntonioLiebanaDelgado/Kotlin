package com.example.mangashelfv2

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.runner.RunWith
import org.junit.Rule
import org.junit.Test
import org.junit.Ignore
import androidx.test.rule.ActivityTestRule
import com.example.mangashelfv2.GetById.DetallesByIdActivity

@RunWith(AndroidJUnit4::class)
class Test5_ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(DetallesByIdActivity::class.java)

    @Ignore("Ignorado debido a cambios intencionales en la visibilidad del botón.")
    @Test
    fun testButtonIsVisible() {
        onView(withId(R.id.btn_link)).check(matches(isDisplayed()))
    }

    @Test
    fun testButtonIsNotVisible() {
        onView(withId(R.id.btn_link)).check(matches(withEffectiveVisibility(Visibility.GONE)))
    }
}

