package com.example.apk1;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasToString;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Drives the real screen on a device or emulator. */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);

    private void run(String number, String operation) {
        onView(withId(R.id.editTextNumberDecimal2)).perform(typeText(number), closeSoftKeyboard());
        onView(withId(R.id.spinner)).perform(click());
        onData(hasToString(operation)).perform(click());
        onView(withId(R.id.button2)).perform(click());
    }

    @Test
    public void emptyFieldShowsAVisibleError() {
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).check(matches(allOf(isDisplayed(),
                withText("Number field can't be empty"))));
    }

    @Test
    public void squareRoot() {
        run("2", "SquareRoot");
        onView(withId(R.id.textView)).check(matches(withText("Answer=1.41")));
    }

    @Test
    public void loneDecimalPointShowsAnErrorInsteadOfCrashing() {
        run(".", "Square");
        onView(withId(R.id.textView)).check(matches(withText("Error! Please enter a valid number")));
    }
}
