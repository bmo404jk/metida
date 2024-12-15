package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {

    private SelenideElement mainInputSearch = $(By.xpath("//input[@name = 'header_search_dublicate']")),
    btnCloseMainMenu = $(By.xpath("//button[@class='scs-modal__close']")),
    bookNameInCard = $(By.xpath("//div[@class ='catalog-item']/div[@class='catalog-item-right']/div/a[@class='catalog-item-name']"));

    public String searchingInMainPage(String s) {
        clickElementS(mainInputSearch);
        mainInputSearch.append(s);
        log.info("Выполняем поиск по названию: " + s);
        mainInputSearch.pressEnter();
        return s;
    }

    public String getNameBook(String nameBook) {
        try {
            log.info("Название найдено: " + nameBook);
            return bookNameInCard.getText().substring(0,searchingInMainPage(nameBook).length());
        } catch (Exception e) {
            log.info("Елемент с названием [" + nameBook + "] не найден");
            log.info("Ошибка: [" + e + "]");
        }
        return bookNameInCard.getText().substring(0,searchingInMainPage(nameBook).length());
    }
}
