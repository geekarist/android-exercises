package fr.android.androidexercises;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

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
        Espresso.onView(ViewMatchers.withId(R.id.usernameEdit)).perform(ViewActions.typeText("cp"));
        Espresso.onView(ViewMatchers.withId(R.id.passwordEdit)).perform(ViewActions.typeText("1234"));
        // When
        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(ViewActions.click());
        // Then
        Espresso.onView(ViewMatchers.withId(R.id.loggedText)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withText(R.string.text_logged))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    public void testShouldNotLoginWithInvalidPassword() {
        // Given
        Espresso.onView(ViewMatchers.withId(R.id.usernameEdit)).perform(ViewActions.typeText("cp"));
        Espresso.onView(ViewMatchers.withId(R.id.passwordEdit)).perform(ViewActions.typeText("1"));
        // When
        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(ViewActions.click());
        // Then
        Espresso.onView(ViewMatchers.withId(R.id.loggedText))
                .check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())));
    }

    public void takeScreenshot(String name) {
        //Spoon.screenshot(getCurrentActivity(), name);
    }

//    public Activity getCurrentActivity() {
//        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
//        instrumentation.waitForIdleSync();
//        final Activity[] activity = new Activity[1];
//        instrumentation.runOnMainSync(new Runnable() {
//            @Override
//            public void run() {
//                ActivityLifecycleMonitor activityLifecycleMonitor = ActivityLifecycleMonitorRegistry.getInstance();
//                java.util.Collection<Activity> resumedActivities = activityLifecycleMonitor.getActivitiesInStage(Stage.RESUMED);
//                activity[0] = Iterables.getOnlyElement(resumedActivities);
//            }
//        });
//        return activity[0];
//    }

}