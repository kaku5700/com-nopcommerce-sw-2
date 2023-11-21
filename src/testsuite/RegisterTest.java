package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        String expectedMessage = "Register";
        String actualMessage = driver.findElement(By.xpath("//h1[contains(text(),'Register')]")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    public static String getRandomEmail() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder random = new StringBuilder();
        Random rnd = new Random();
        while (random.length() < 10) {
            int index = (int) (rnd.nextFloat() * chars.length());
            random.append(chars.charAt(index));
        }
        String email = random.toString() + "@gmail.com";
        return email;
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Hello");
        driver.findElement(By.name("LastName")).sendKeys("Patel");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("15");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("1983");
        driver.findElement(By.id("Email")).sendKeys(getRandomEmail());
        driver.findElement(By.name("Password")).sendKeys("prime123");
        driver.findElement(By.name("ConfirmPassword")).sendKeys("prime123");
        driver.findElement(By.name("register-button")).click();
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("User not able to regiester.", expectedMessage, actualMessage);
    }

    @After //JUnit Annotation which will run after every Method
    public void tearDown() {
        closeBrowser();
    }

}
