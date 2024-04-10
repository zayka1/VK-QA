package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogOutTest extends BaseTest {
    final String CORRECT_LOGOUT_URL = "https://ok.ru/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose";

    @Test
    public void logOutTest() {
        MainPage mainPage = new MainPage();
        mainPage.logOut();

        LoginPage loginPage = new LoginPage();

        Assertions.assertEquals(CORRECT_LOGOUT_URL, WebDriverRunner.url());
    }
}
