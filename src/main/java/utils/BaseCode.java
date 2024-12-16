package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import listeners.Log;
import org.openqa.selenium.By;
import pages.BasketPage;
import pages.LoginPage;
import pages.MainPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class BaseCode extends Log {

    protected int S = 1500;
    protected int M = 10000;
    protected int L = 20000;
    private String login = "buffo404@gmail.com";
    private String password = "q2a3fer78po93";

    private SelenideElement mainInputSearch = $(By.xpath("//input[@name = 'header_search_dublicate']")),
    btnCloseMainMenu = $(By.xpath("//button[@class='scs-modal__close']")),
    fioAccount = $(By.xpath("//a[@class='header-auth-top-name']")),
    buyButton = $(By.xpath("//div[@class = 'detail-info-btn-block']/a[contains(text(), 'Купить')]")),
    basketButton = $(By.xpath("//div[@class = 'header-bottom-shop']/a[@class='header-basket add']")),
    countProductsInBasket = $(By.xpath("//div[@class = 'header-bottom-shop']/a[@class='header-basket add']//div[2]")),
    bookNameInCard = $(By.xpath("//div[@class='catalog-list']/div/div/div/a[2]"));

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

    public void clickOnFirstBookInList() {
        sleep(1500);
        $(By.xpath("//div[@class = 'catalog-list']/div[1]")).click();
    }

    public void clickBuyButton() {
        buyButton.click();
    }

    public void clickBasketButton() {
        sleep(1000);
        basketButton.click();
    }

    public String getBasketButtonCountProducts() {
        sleep(1000);
        if(!countProductsInBasket.exists()) {
            log.info("Корзина пуста");
            return "0";
        } else  log.info("Сейчас в корзине [" + countProductsInBasket.getText() + "] продуктов");
        sleep(1000);
      return countProductsInBasket.getText();
    }

    public void compareProductsCountInBasket(int startCount, int endCount) {
        log.info("В корзине было [" + startCount + "] ---> В корзине стало [" + endCount + "]");
    }

    public void searchingInMainPage(String author,String nameBook) {
        sleep(1000);
        clickElementS(mainInputSearch);
        if (author != null) {
            log.info("Выполняем поиск по названию и автору: " + "Автор + [" + author + "], Название [" + nameBook + "]");
            mainInputSearch.append(author + " " + nameBook);
            mainInputSearch.pressEnter();
        } else if (author == null) {
            log.info("Выполняем поиск по названию: Название [" + nameBook + "]");
            mainInputSearch.append(nameBook);
            mainInputSearch.pressEnter();
        } else if (nameBook == null) {
            log.info("Выполняем поиск по автору: Название [" + author + "]");
            mainInputSearch.append(nameBook);
            sleep(1000);
            mainInputSearch.pressEnter();
        }
    }

    public String getNameBook(String nameBook) {
        log.info("Название найдено: " + nameBook);

        String input = bookNameInCard.getText();
        Pattern pattern = Pattern.compile(nameBook);
        Matcher matcher = pattern.matcher(input);
        String extractedText = "";

        if (matcher.find()) {
            extractedText = matcher.group();
            return extractedText;
        } else {
            log.info("Соответствие не найдено.");
        }
        return extractedText;
    }

    public String getAuthorBook(String bookAuthor) {
        log.info("Автор найден: " + bookAuthor);

        String input = bookNameInCard.getText();
        Pattern pattern = Pattern.compile(bookAuthor);
        Matcher matcher = pattern.matcher(input);
        String extractedText = "";

        if (matcher.find()) {
            extractedText = matcher.group();
            return extractedText;
        } else {
            log.info("Соответствие не найдено.");
        }
        return extractedText;
    }
    public void compareSearchResult(String author, String nameBook) {
        sleep(1000);
        if(bookNameInCard.text().contains(author) && bookNameInCard.text().contains(nameBook)) {
            log.info("Книга найдена и отображается в списке книг");
        } else log.info("Книга НЕ найдена и НЕ отображается в списке книг");
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
    public SelenideElement getFioAccountElement() {
        return fioAccount;
    }
}
