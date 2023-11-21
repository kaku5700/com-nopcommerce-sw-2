package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        // Find the login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText();
        Assert.assertEquals("User was not navigated.", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldLoginWithValidCredentials() {
        driver.findElement(By.linkText("Log in")).click();

        // Find the Email Field Type the Email address to email field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("jaynikapatel1@gmail.com");

        // Find the password field and Type the password to password field
        driver.findElement(By.name("Password")).sendKeys("12345678");

        // Find the login btn element and click
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();

        String expectedMessage = "Log out";
        String actualMessage = driver.findElement(By.linkText("Log out")).getText();
        Assert.assertEquals("User was unable to login successfully.", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.linkText("Log in")).click();//click on login link
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("jaynika@gmail.com");//enter email address
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");//enter password
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();//click on login button

        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        // Find the errorMessage element and get the text
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("Error message not displayed", expectedErrorMessage, actualErrorMessage);
    }

    @After
   public void tearDown() {
        closeBrowser();
    }
}

