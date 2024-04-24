package com.example.espresso_testing1

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testActivityRuns() {
        onView(withId(R.id.maintext)).check(matches(isDisplayed()))
    }

    @Test
    fun testActivityWithHelloWorld() {
        onView(withText("Hello World!")).check(matches(isDisplayed()))
    }

    @Test
    fun testButtonClickChangesText() {
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.maintext)).check(matches(withText("Bye World!")))
    }

    @Test
    fun testButtonShowsEditText() {
        val testText = "Golaassooo"
        onView(withId(R.id.editText)).perform(typeText(testText), closeSoftKeyboard())
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.maintext)).check(matches(withText(testText)))
    }
}