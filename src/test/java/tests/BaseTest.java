package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.LoginPage;
import pages.LoginPageFactory;
import pages.ProductsPage;

import java.util.concurrent.TimeUnit;
@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    LoginPageFactory loginPageFactory;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }

    public void initPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
    }
}