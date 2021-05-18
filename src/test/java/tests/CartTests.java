package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    @Test
    public void addProductToCartTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }
}
