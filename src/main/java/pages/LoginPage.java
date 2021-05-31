package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;


public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    public static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    public static final By BOT_LOGO = By.xpath("//*[@id='bot_column-button']");

    public ProductsPage login(String username, String password) {
        waitForElementLocated(USERNAME_INPUT, 10);
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        waitForElementLocated(PASSWORD_INPUT, 10);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    public boolean isElementDisplayed() {
        List<WebElement> elementList =  driver.findElements(USERNAME_INPUT);
        return !elementList.isEmpty();
    }

    public void sendFileExample() {
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("путь к файлу");
        driver.findElement(By.cssSelector("Кнопка старта загрузки")).click();
    }

    public void enterIframeText() {
        driver.switchTo().frame((WebElement) By.id("mce_0_ifr"));
        driver.findElement(By.xpath("data-id")).sendKeys("Text");
        driver.switchTo().defaultContent();
    }

    public LoginPage openPage() {
        super.openPage(LOGIN_URL);
        return this;
    }

    public void waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(BOT_LOGO));
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement foo = fluent.until(driver -> driver.findElement(By.id("foo")));
    }

    public LoginPage waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return this;
    }
}