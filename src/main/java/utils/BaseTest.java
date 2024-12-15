package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import listeners.Log;
import org.openqa.selenium.Cookie;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BasePage;
import pages.LoginPage;
import pages.MainPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest extends Log {

    String chrome = "chrome";
    int countPassedTest = 0;
    int countFailedTest = 0;
    int countSkipTest = 0;

    protected Log log = new Log();
    protected MainPage mainPage = new MainPage();
    protected LoginPage loginPage = new LoginPage();
    protected BasePage basePage = new BasePage();

    @BeforeSuite
    public void BeforeTest() {
        log.info("===============================================");
        log.info("Запуск тестового класса: " + "[" + this.getClass().getSimpleName() + "]");
        Configuration.browser = chrome;
        Configuration.browserSize = "1920x1080";

        log.info("Запускаем браузер: [" + chrome + "]");
        System.setProperty("webdriver.chrome.driver", "src//main//resources//webdriver//131.0.6778.69//chromedriver.exe");
        open("https://www.metida.ru/");

        //входим в аккаунт
        loginPage.login(loginPage.getLogin(), loginPage.getPassword());
    }

    @AfterMethod
    public void afterEachTest(ITestResult testResult) {
        if (testResult.isSuccess()) {
            log.info("Тест [" + testResult.getName() + "] успешно завершен.");
            countPassedTest++;
        } else if (testResult.getStatus() == ITestResult.FAILURE) {
            log.error("Тест [" + testResult.getName() + "] завершился неудачно.");
            countFailedTest++;
        } else if (testResult.getStatus() == ITestResult.SKIP) {
            log.warn("Тест [" + testResult.getName() + "] был пропущен.");
            countSkipTest++;
        }
    }

    @AfterSuite
    public void AfterTest() {
        log.info("===============================================");
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedTime = currentTime.format(formatter);

        log.info("Тесты завершены: [" + formattedTime + "]");
        log.info("Пройденные тесты: [" + countPassedTest + "]");
        log.info("Проваленные тесты: [" + countFailedTest + "]");
        log.info("Тестов пропущено: [" + countSkipTest + "]");
        log.info("===============================================");
        log.clearLogs();
    }
    //не нашёл нужные куки...
    public void setCookies(String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
    }
}
