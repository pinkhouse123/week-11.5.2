package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Click Sign In button and Welcome Back text
        //driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]")).click();
        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        //driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]")).click();
        clickOnElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));

    }

    @Test
    public void verifyTheErrorMessage() {
        // Find sing in link and click on login link
        //driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]")).click();
        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));

        // Find the email field element
        //WebElement emailField = driver.findElement(By.id("user[email]"));
        sendTextToElement(By.id("user[email]"), "prime1@gmail.com");
        // Sending email to email field element
        //emailField.sendKeys("prime1@gmail.com");

        // Find the password field element
        //WebElement passwordField = driver.findElement(By.name("user[password]"));
        sendTextToElement(By.name("user[password]"), "Prime1");
        // Sending Password to password field element
        //passwordField.sendKeys("Prime1");

        //Find the login button and click on it
        //WebElement loginButton = driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        //loginButton.click();
        clickOnElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));

        String expectedErrorMessage = "Invalid email or password.";
        //String actualErrorMessage = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]")).getText();
        String actualErrorMessage = getTextFromElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));

        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedErrorMessage, actualErrorMessage);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}




