import enums.Lovecraft;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.BaseTest;

public class Test002 extends BaseTest {

    /*
     * Нужно залогиниться, найти в списке на главной странице книгу
     * проверить, что в карточке отображается автор, котороый
     * указан в поиске
     */

    @Test(description = "Проверка выполнения поиска с главной страницы")
    @Description("Осуществляем поиск по имени автора книги")
    public void searchingAuthorBookName() {
        mainPage.searchingInMainPage(Lovecraft.AUTHOR.toString(),Lovecraft.LURKING_AT_THE_THRESHOLD.toString());
        mainPage.compareSearchResult(Lovecraft.AUTHOR.toString(),Lovecraft.DREAMS_OF_CTHULHU.toString());
    }
}
