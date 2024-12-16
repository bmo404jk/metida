package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.BaseCode;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BaseCode {

    private SelenideElement loginButton = $(By.xpath("//a[contains(text(), 'Войти') and contains(@href, '/auth/')]")),
    elementEnterWithPassword = $(By.xpath("//a[@class = 'bxmaker-authuserphone-link' and contains(text(),'Войти с помощью пароля')]")),
    loginIpnut = $(By.xpath("//input[@name = 'PHONE_LOGIN_EMAIL']")),
    passwordInput = $(By.xpath("//input[@name = 'PASSWORD']")),
    enterButton = $(By.xpath("//div[@class='bxmaker-authuserphone-enter-auth-by-password-form']/button"));

    public LoginPage login(String login, String password) {
        closeBtn();
        clickElementS(loginButton);
        clickElementS(elementEnterWithPassword);
        log.info("Вводим логин [" +  getLogin() + "]");
        clickElementS(loginIpnut);
        loginIpnut.append(login);
        clickElementS(passwordInput);
        log.info("Заполняем пароль");
        passwordInput.append(password);
        clickElementS(enterButton);
        log.info("Выполняем вход в аккаунт...");
        return this;
    }

}
