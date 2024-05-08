package com.lasalle.newsletter

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.PositionAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Test_4 {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun validateElementPositions() {

        onView(withId(R.id.et_name)).check(PositionAssertions.isAbove(withId(R.id.et_email)))

        onView(withId(R.id.et_email)).check(PositionAssertions.isAbove(withId(R.id.cb_subs)))

        onView(withId(R.id.cb_subs)).check(PositionAssertions.isAbove(withId(R.id.bt_signup)))

        onView(withId(R.id.bt_signup)).check(PositionAssertions.isAbove(withId(R.id.tv_help)))
    }
}
