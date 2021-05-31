package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import static test_data.TestConstants.PASSWORD;
import static test_data.TestConstants.USERNAME;

public class LoginTest extends BaseTest{

    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addButton;

    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteButton;

    @Test
    public void loginFactoryTest () {
        loginPageFactory.openPage();
        loginPageFactory.loginFactory(USERNAME, PASSWORD);
    }


//    DEMO CODE:
//
//    @Test
//    public void demoWithoutPageFactory() {
//        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
//        WebElement addButton = driver.findElement(By.xpath("//button[contains(.,'Add')]"));
//        addButton.click();
//        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
//        deleteButton.click();
//        addButton.click();
//        deleteButton.click();
//    }
//
//    @Test
//    public void demoWithPageFactory() {
//        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
//        WebElement addButtonElement = addButton;
//        addButtonElement.click();
//        WebElement deleteButtonElement = deleteButton;
//        deleteButtonElement.click();
//        addButtonElement.click();
//        deleteButtonElement.click();
//    }
}