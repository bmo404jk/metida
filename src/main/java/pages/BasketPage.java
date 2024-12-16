package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.BaseCode;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class BasketPage extends BaseCode {
    private SelenideElement emptyBasketMessage = $(By.xpath("//div[@class = 'basket-empty']/div[contains(text(),'отсутствуют')]")),
    clearAllBasketButton = $(By.xpath("//div[@class ='basket-clear-btn']"));;

    public void checkBasket() {

        if(emptyBasketMessage.exists()) {
            log.info("Корзина пуста");
        } else {

        }
    }
    public void clearAllInBasket() {
        sleep(1000);
        clearAllBasketButton.click();
    }
}
