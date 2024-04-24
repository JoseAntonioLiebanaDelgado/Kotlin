package com.example.espresso_testing2

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isSystemAlertWindow
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
    fun testEmptyFields() {
        onView(withId(R.id.buttonLogin)).perform(click())
        onView(withId(R.id.buttonLogin)).check(matches(isDisplayed()))
    }

    @Test
    fun testIncorrectPassword() {
        onView(withId(R.id.inputUsername)).perform(typeText("admin"))
        onView(withId(R.id.inputPassword)).perform(typeText("incorrectPassword"))
        onView(withId(R.id.buttonLogin)).perform(click())
        onView(withId(R.id.buttonLogin)).check(matches(isDisplayed()))
    }

    @Test
    fun testIncorrectUsername() {
        onView(withId(R.id.inputUsername)).perform(typeText("incorrectUsername"))
        onView(withId(R.id.inputPassword)).perform(typeText("admin"))
        onView(withId(R.id.buttonLogin)).perform(click())
        onView(withId(R.id.buttonLogin)).check(matches(isDisplayed()))
    }

    @Test
    fun testCorrectLogin() {
        onView(withId(R.id.inputUsername)).perform(typeText("admin"))
        onView(withId(R.id.inputPassword)).perform(typeText("admin"))
        onView(withId(R.id.buttonLogin)).perform(click())
        onView(withId(R.id.welcomeText)).check(matches(isDisplayed()))
    }

    @Test
    fun testCorrectGuest() {
        onView(withId(R.id.inputUsername)).perform(typeText("guest"))
        onView(withId(R.id.inputPassword)).perform(typeText("guest"))
        onView(withId(R.id.buttonLogin)).perform(click())
        onView(withText("Welcome, guest!")).check(matches(isDisplayed()))
    }

    @Test
    fun testCorrectAdmin() {
        onView(withId(R.id.inputUsername)).perform(typeText("admin"))
        onView(withId(R.id.inputPassword)).perform(typeText("admin"))
        onView(withId(R.id.buttonLogin)).perform(click())
        onView(withText("Welcome, admin!")).check(matches(isDisplayed()))
    }
}