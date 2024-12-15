import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class Test002 extends BaseTest {

    @Test(description = "Проверка выполнения поиска с главной страницы")
    @Description("Осуществляем поиск по имени автора книги")
    public void searchingAuthorBookName() {
        String s = "Лавкрафт";
        mainPage.searchingInMainPage(s);
        Assert.assertEquals(s, mainPage.getNameBook(s));
    }
}
