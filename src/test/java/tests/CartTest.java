package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static test_data.TestConstants.PASSWORD;
import static test_data.TestConstants.USERNAME;

public class CartTest extends BaseTest {

    @DataProvider(name = "Входящие данные для Продуктов")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {"Sauce Labs Bolt T-Shirt", "$15.99"},
                {"Sauce Labs Backpack", "$29.99"}
        };
    }

    @Parameters({PASSWORD})
    @Test(dataProvider = "Входящие данные для Продуктов")
    public void addProductToCartTest(@Optional("1") String p1, String productName, String productPrice) {
        loginPage
                .openPage()
                .login(USERNAME, p1)
                .addProductToCart(productName);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(productName), productPrice);
    }
}