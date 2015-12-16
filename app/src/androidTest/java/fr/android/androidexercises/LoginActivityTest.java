package fr.android.androidexercises;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.core.deps.guava.collect.Iterables;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitor;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.test.ActivityInstrumentationTestCase2;

import com.squareup.spoon.Spoon;

import org.hamcrest.Matchers;

public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
    }

    public void testShouldLoginWithPassword() {
        // Given
        takeScreenshot("testShouldLoginWithPassword1");
        Espresso.onView(ViewMatchers.withId(R.id.usernameEdit)).perform(ViewActions.typeText("cp"));
        takeScreenshot("testShouldLoginWithPassword2");
        Espresso.onView(ViewMatchers.withId(R.id.passwordEdit)).perform(ViewActions.typeText("1234"));

        // When
        takeScreenshot("testShouldLoginWithPassword3");
        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(ViewActions.click());

        // Then
        takeScreenshot("testShouldLoginWithPassword4");
        Espresso.onView(ViewMatchers.withId(R.id.loggedText)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        takeScreenshot("testShouldLoginWithPassword5");
        Espresso.onView(ViewMatchers.withText(R.string.text_logged))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        takeScreenshot("testShouldLoginWithPassword6");
    }

    public void testShouldNotLoginWithInvalidPassword() {
        // Given
        takeScreenshot("testShouldNotLoginWithInvalidPassword1");
        Espresso.onView(ViewMatchers.withId(R.id.usernameEdit)).perform(ViewActions.typeText("cp"));
        takeScreenshot("testShouldNotLoginWithInvalidPassword2");
        Espresso.onView(ViewMatchers.withId(R.id.passwordEdit)).perform(ViewActions.typeText("1"));
        // When
        takeScreenshot("testShouldNotLoginWithInvalidPassword3");
        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(ViewActions.click());
        // Then
        takeScreenshot("testShouldNotLoginWithInvalidPassword4");
        Espresso.onView(ViewMatchers.withId(R.id.loggedText))
                .check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())));
        takeScreenshot("testShouldNotLoginWithInvalidPassword5");
    }

    public void takeScreenshot(String name) {
        Spoon.screenshot(getCurrentActivity(), name);
    }

    public Activity getCurrentActivity() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        instrumentation.waitForIdleSync();
        final Activity[] activity = new Activity[1];
        instrumentation.runOnMainSync(new Runnable() {
            @Override
            public void run() {
                ActivityLifecycleMonitor activityLifecycleMonitor = ActivityLifecycleMonitorRegistry.getInstance();
                java.util.Collection<Activity> resumedActivities = activityLifecycleMonitor.getActivitiesInStage(Stage.RESUMED);
                activity[0] = Iterables.getOnlyElement(resumedActivities);
            }
        });
        return activity[0];
    }

}