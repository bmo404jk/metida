package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import listeners.Log;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class BasePage extends Log {

    protected int S = 1500;
    protected int M = 10000;
    protected int L = 20000;
    private String login = "buffo404@gmail.com";
    private String password = "q2a3fer78po93";

    private SelenideElement mainInputSearch = $(By.xpath("//input[@name = 'header_search_dublicate']")),
    btnCloseMainMenu = $(By.xpath("//button[@class='scs-modal__close']")),
    fioAccount = $(By.xpath("//a[@class='header-auth-top-name']"));

    public void clickElementS(SelenideElement se) {
        sleep(S);
        se.click();
    }
    public void clickElementM(SelenideElement se) {
        sleep(M);
        se.click();
    }
    public void clickElementL(SelenideElement se) {
        sleep(L);
        se.click();
    }

    public void closeBtn() {
        if(btnCloseMainMenu.isDisplayed()) {
            log.info("Нажимаем на кнопку закрытия всплывающего окна....");
            btnCloseMainMenu.should(Condition.visible).should(Condition.clickable);
            btnCloseMainMenu.click();
        } else System.out.println("Закрытие начального всплывающего окна не требуется.");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    public String getFioAccount() {
        return fioAccount.getText();
    }
}
