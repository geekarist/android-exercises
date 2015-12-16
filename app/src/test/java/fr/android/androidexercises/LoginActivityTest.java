package fr.android.androidexercises;

import org.assertj.android.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

@RunWith(CustomRobolectricTestRunner.class)
public class LoginActivityTest {

    @Test
    public void shouldShowLoggedText() {
        // Given
        LoginActivity activity = Robolectric.setupActivity(LoginActivity.class);

        // When
        activity.logged();

        // Then
        Assertions.assertThat(activity.loggedText).isVisible();
    }

    @Test
    public void shouldNotShowLoggedText() {
        // When
        LoginActivity activity = Robolectric.setupActivity(LoginActivity.class);

        // Then
        Assertions.assertThat(activity.loggedText).isGone();
    }

    @Test
    public void shouldCheckCredentials() {
        // Given
        LoginActivity activity = Robolectric.setupActivity(LoginActivity.class);
        activity.presenter = Mockito.mock(LoginPresenter.class);
        activity.passwordEdit.setText("yo");

        // When
        activity.loginButton.callOnClick();

        // Then
        Mockito.verify(activity.presenter).checkCredentials("yo");
    }

}