package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginInput = $(By.xpath(".//input[@data-l='t,login']"));
    private final SelenideElement passwordInput = $(By.xpath(".//input[@data-l='t,password']"));
    private final SelenideElement loginButton = $(By.xpath(".//input[@data-l='t,password']"));
    private final SelenideElement loginQrButton = $(By.xpath(".//a[@data-l='t,get_qr']"));
    private final SelenideElement registerButton = $(By.xpath(".//a[@class='button-pro __sec mb-3x __wide']"));
    private final SelenideElement loginErrorText = $(By.xpath(".//*[@class='input-e login_error']"));

    public LoginPage() {
        open();
        checkLoginPage();
    }

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public void checkLoginPage() {
        loginInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        loginButton.shouldBe(visible);
        loginQrButton.shouldBe(visible);
        registerButton.shouldBe(visible);
    }

    public void signIn(String login, String password) {
        loginInput.setValue(login);
        passwordInput.setValue(password).pressEnter();
    }

    public String getIncorrectLoginText() {
        loginErrorText.shouldBe(visible);
        return loginErrorText.getText();
    }
}
