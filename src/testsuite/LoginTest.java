package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        WebElement emailField=driver.findElement(By.id("txtUsername"));//emailfield locator
        emailField.sendKeys("Admin");//send keys
        WebElement passwordField=driver.findElement(By.id("txtPassword"));//password field
        passwordField.sendKeys("admin123");//send keys to password field
        WebElement loginBtn= driver.findElement(By.id("btnLogin"));//loginbutton locators
        loginBtn.click();//click on login button
        String welcomeText=driver.findElement(By.id("welcome")).getText();// get welcome text
        String actualText=welcomeText.substring(0,7);// split the text
        String expectedTeXt="Welcome";// expected text
        Assert.assertEquals("Welcome text not visible", expectedTeXt,actualText);// validation
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
