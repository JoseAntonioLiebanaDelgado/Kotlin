package com.lasalle.newsletter

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Test_3 {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun validateDataTransferToSecondActivity() {

        onView(withId(R.id.et_name)).perform(typeText("Pepe"))
        onView(withId(R.id.et_email)).perform(typeText("pepe@example.com"))

        onView(withId(R.id.cb_subs)).perform(click())

        onView(withId(R.id.bt_signup)).perform(click())

        onView(withId(R.id.et_email)).check(matches(withText("pepe@example.com")))
    }
}
