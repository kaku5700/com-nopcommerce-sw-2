package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComuterPageSuccessfully() {
        driver.findElement(By.xpath("(//a[@href='/computers'])[1]")).click();
        String expectedMessage = "Computers";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("User was not Navigated to Computers page.", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNotNavigateToElectronicsPageSuccessfully() {
        driver.findElement(By.xpath("(//a[text()='Electronics '])[1]")).click();
        String expectedMessage = "Electronics";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("User was not Navigated to Electronics page.", expectedMessage,actualMessage);

    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        driver.findElement(By.xpath("//a[@href='/apparel']")).click();
        String expectedMessage = "Apparel";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("User was not Navigated to Apparel page.", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        driver.findElement(By.xpath("//a[@href='/digital-downloads']")).click();
        String expectedMessage = "Digital downloads";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("User was not Navigated to Digital Downloads page.", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        driver.findElement(By.xpath("//a[@href='/books']")).click();
        String expectedMessage = "Books";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("User was not Navigated to Books page.", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        driver.findElement(By.xpath("(//a[contains(text(),'Jewelry')])[1]")).click();
        String expectedMessage = "Jewelry";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("User was not Navigated to Jewerly page.", expectedMessage, actualMessage);
    }
    @Test
    public void userShouldNavigateToGiftCardPageSuccessfully() {
        driver.findElement(By.xpath("//a[@href='/gift-cards']")).click();
        String expectedMessage = "Gift Cards";
        String actualMessage = driver.findElement(By.xpath("//a[@href='/gift-cards']")).getText();
        Assert.assertEquals("User was not Navigated to Gift Cards page.", expectedMessage, actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}



