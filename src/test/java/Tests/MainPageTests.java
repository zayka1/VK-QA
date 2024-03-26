package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import org.junit.jupiter.api.Test;

public class MainPageTests extends BaseTest {
    MainPage mainPage = new MainPage();

    @Test
    public void checkSignInTest() {
        mainPage.openLoggedIn().checkMainPage();
    }

    @Test
    public void logOutTest() {
        mainPage.openLoggedIn().logOut();

        LoginPage loginPage = new LoginPage();
        loginPage.checkLoginPage();

    }
}
