package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static test_data.TestConstants.PASSWORD;
import static test_data.TestConstants.USERNAME;

public class ProductsTest extends BaseTest {

    @DataProvider(name = "Входящие данные для Продуктов")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {"Sauce Labs Bolt T-Shirt", "$15.99"},
 //               {"Sauce Labs Backpack", "$31.99"}
        };
    }

    @Test(retryAnalyzer = Retry.class, dataProvider = "Входящие данные для Продуктов")
    public void addProductToCartTest(String productName, String productPrice) {
        loginPage
                .openPage()
                .login(System.getProperty(USERNAME), System.getProperty(PASSWORD))

                .addProductToCart(productName);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(productName), productPrice);
    }
}