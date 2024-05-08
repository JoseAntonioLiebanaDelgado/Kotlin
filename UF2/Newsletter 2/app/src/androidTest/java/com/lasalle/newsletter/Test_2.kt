package com.lasalle.newsletter

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Test_2 {

    @get:Rule
    var intentsTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun testHelpLinkLaunchesBrowser() {

        Intents.init()
        onView(withId(R.id.tv_help)).perform(click())

        intended(allOf(
            IntentMatchers.hasAction(Intent.ACTION_VIEW),
            IntentMatchers.hasData("https://newsletterguide.org")
        ))

        Intents.release()
    }
}
