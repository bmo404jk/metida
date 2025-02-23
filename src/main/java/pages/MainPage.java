package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.BaseCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BaseCode {

    private SelenideElement mainInputSearch = $(By.xpath("//input[@name = 'header_search_dublicate']")),
    btnCloseMainMenu = $(By.xpath("//button[@class='scs-modal__close']")),
    bookNameInCard = $(By.xpath("//div[@class='catalog-list']/div/div/div/a[2]"));

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
}
