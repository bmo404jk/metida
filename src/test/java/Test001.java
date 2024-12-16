import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BaseTest;

public class Test001 extends BaseTest {

    /*
     * Нужно залогиниться в систему по логину и паролю
     */

    @Test(description = "Проверка входа в аккаунт.")
    @Description("Простая проверка входа в аккаунт с проверкой соответствия отображемого логина после входа.")
    public void loginTest() {

        Assert.assertEquals(baseCode.getFioAccount(),"Алекасндр Б.");
    }
}
