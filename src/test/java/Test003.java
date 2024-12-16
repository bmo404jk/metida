import enums.Bradbury;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.BaseTest;


public class Test003 extends BaseTest {

    /*
    * Нужно залогиниться, найти в списке на главной странице книгу
    * кликнуть на карточку с книгой,
    * добавить книгу в корзину,
    * проверить, что книга добавлена в корзину
    * (сравнить значение до добавления в корзину и после, должно быть увеличение
    * на количестов добавленных в корзину книг)
     */

    @Test(description = "Проверка добавления книги в корзину ")
    @Description("Добавляем в корзину книгу, проверяем, что книга добавляется и отображается")
    public void searchingAuthorBookName() {

        int startCountProductsInBasket = Integer.parseInt(baseCode.getBasketButtonCountProducts());
        mainPage.searchingInMainPage(Bradbury.AUTHOR.toString(),Bradbury.THE_MARTIAN_CHRONICLES.toString());
        baseCode.clickOnFirstBookInList();
        baseCode.clickBuyButton();

        int endCountProductsInBasket = Integer.parseInt(baseCode.getBasketButtonCountProducts());
        baseCode.clickBasketButton();
        basketPage.clearAllInBasket();
        baseCode.compareProductsCountInBasket(startCountProductsInBasket,endCountProductsInBasket);
    }
}
