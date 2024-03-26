package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement navigationToolBar = $(By.xpath("//div[@data-l='t,navigationToolbar']"));
    private final ElementsCollection navigationToolBarButtons = $$(By.xpath("//*[contains(@class,'toolbar_nav_a')]"));
    private final ElementsCollection navigationButtons = $$(By.xpath("//div[@class='nav-side_i-w']"));
    private final SelenideElement navigationBar = $(By.xpath("//div[@class='nav-side __navigation __user-main']"));
    private final SelenideElement profileSettingsButton = $(By.xpath("//button[@aria-label='Profile settings']"));
    private final SelenideElement logOutButton = $(By.xpath("//div[@class='toolbar_accounts-user-delete-button']"));
    private final SelenideElement finalLogOutButton = $(By.xpath("//input[@data-l='t,logout']"));

    public MainPage openLoggedIn() {
        LoginPage loginPage = new LoginPage();
        Selenide.open("/");
        loginPage.signIn("technopol56", "technopolisPassword");
        return this;
    }

    public void checkMainPage() {
        navigationToolBar.shouldBe();
        navigationBar.shouldBe();
        Assertions.assertEquals(8, navigationToolBarButtons.size());
        Assertions.assertEquals(11, navigationButtons.size());
    }

    public void logOut() {
        profileSettingsButton.click();
        logOutButton.click();
        finalLogOutButton.click();
    }
}
