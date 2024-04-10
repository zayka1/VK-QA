package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement navigationToolBar = $(By.xpath(".//*[@data-l='t,navigationToolbar']"));
    private final ElementsCollection navigationToolBarButtons = $$(By.xpath(".//*[contains(@class,'toolbar_nav_a')]"));
    private final ElementsCollection navigationButtons = $$(By.xpath(".//*[@class='nav-side_i-w']"));
    private final SelenideElement navigationBar = $(By.xpath(".//*[@class='nav-side __navigation __user-main']"));
    private final SelenideElement profileSettingsButton = $(By.xpath(".//button[@aria-label='Profile settings']"));
    private final SelenideElement logOutButton = $(By.xpath(".//*[@class='toolbar_accounts-user-delete-button']"));
    private final SelenideElement finalLogOutButton = $(By.xpath(".//input[@data-l='t,logout']"));

    public MainPage() {
        openLoggedIn();
        checkMainPage();
    }

    public MainPage openLoggedIn() {
        LoginPage loginPage = new LoginPage();
        loginPage.signIn("technopol56", "technopolisPassword");
        return this;
    }

    public void checkMainPage() {
        navigationToolBar.shouldBe(visible.because("navigationToolBar should be visible"));
        navigationBar.shouldBe(visible.because("navigationBar should be visible"));

        for (SelenideElement selenideElement : navigationToolBarButtons) {
            selenideElement.shouldBe(visible.because("ToolBar buttons should be visible"));
        }

        for (var selenideElement : navigationButtons) {
            selenideElement.shouldBe(visible.because("Navigation buttons should be visible"));
        }

    }

    public void logOut() {
        profileSettingsButton.click();
        logOutButton.click();
        finalLogOutButton.click();
    }
}
