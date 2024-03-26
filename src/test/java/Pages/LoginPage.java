package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginInput = $(By.xpath("//input[@data-l='t,login']"));
    private final SelenideElement passwordInput = $(By.xpath("//input[@data-l='t,password']"));
    private final SelenideElement loginButton = $(By.xpath("//input[@data-l='t,password']"));
    private final SelenideElement loginQrButton = $(By.xpath("//a[@data-l='t,get_qr']"));
    private final SelenideElement registerButton = $(By.xpath("//a[@class='button-pro __sec mb-3x __wide']"));
    private final SelenideElement loginErrorText = $(By.xpath("//div[@class='input-e login_error']"));

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public void checkLoginPage() {
        loginInput.shouldBe();
        passwordInput.shouldBe();
        loginButton.shouldBe();
        loginQrButton.shouldBe();
        registerButton.shouldBe();
    }

    public void signIn(String login, String password) {
        loginInput.setValue(login);
        passwordInput.setValue(password).pressEnter();
    }

    public void checkIncorrectLogin() {
        loginErrorText.shouldBe();
        Assertions.assertEquals("Incorrect username and/or password", loginErrorText.getText());
    }
}
