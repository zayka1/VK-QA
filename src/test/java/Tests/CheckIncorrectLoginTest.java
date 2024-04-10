package Tests;

import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckIncorrectLoginTest extends BaseTest {

    @Test
    public void checkIncorrectLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.signIn("Incorrect_login", "Incorrect_password");

        Assertions.assertEquals("Incorrect username and/or password", loginPage.getIncorrectLoginText());
    }
}
