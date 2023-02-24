package com.github.ninogerber.bootcamp

import android.app.Activity
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class GreetingActivityTest {
    @Test
    fun isCorrectlyCreated() {
        Intents.init()
        val intent = Intent(
            ApplicationProvider.getApplicationContext(),
            GreetingActivity::class.java
        )
        intent.putExtra("name", "Donald Duck")
        val scenario = ActivityScenario.launch<Activity>(intent)
        val textField = onView(ViewMatchers.withId(R.id.GreetingId))
        textField.check(matches(ViewMatchers.withText("Donald Duck")))
        scenario.close()
        Intents.release()
    }
}