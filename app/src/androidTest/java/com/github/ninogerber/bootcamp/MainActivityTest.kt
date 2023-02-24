package com.github.ninogerber.bootcamp

import com.github.ninogerber.bootcamp.R;
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.ninogerber.bootcamp.GreetingActivity
import com.github.ninogerber.bootcamp.MainActivity
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    var testRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun createsCorrectIntent() {
        Intents.init()
        val textField = Espresso.onView(ViewMatchers.withId(R.id.NameId))
        textField.perform(ViewActions.clearText())
        textField.perform(ViewActions.typeText("Donald Duck"))
        textField.perform(ViewActions.closeSoftKeyboard())
        val button = Espresso.onView(ViewMatchers.withId(R.id.btnMainId))
        button.perform(ViewActions.click())
        Intents.intended(
            Matchers.allOf(
                IntentMatchers.hasExtra("name", "Donald Duck"), IntentMatchers.hasComponent(
                    GreetingActivity::class.java.name
                )
            )
        )
        Intents.release()
    }
}