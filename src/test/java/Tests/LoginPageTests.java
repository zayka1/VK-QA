package Tests;

import Pages.LoginPage;
import org.junit.jupiter.api.Test;

public class LoginPageTests extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void checkLoginPageTest() {
        loginPage.open().checkLoginPage();
    }

    @Test
    public void checkIncorrectLoginTest() {
        loginPage.open().signIn("asd", "asd");
        loginPage.checkIncorrectLogin();
    }
}
