package fr.android.androidexercises;

import org.junit.Test;
import org.mockito.Mockito;

public class LoginPresenterTest {

    @Test
    public void shouldLogInWithValidPassword() {
        // Given
        LoginActivity activity = Mockito.mock(LoginActivity.class);
        LoginPresenter loginPresenter = new LoginPresenter(activity);

        // When
        loginPresenter.checkCredentials("soleil");

        // Then
        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);
    }

    @Test
    public void shouldNotLogInWithInvalidPassword() {
        // Given
        LoginActivity activity = Mockito.mock(LoginActivity.class);
        LoginPresenter loginPresenter = new LoginPresenter(activity);

        // When
        loginPresenter.checkCredentials("");

        // Then
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }

}