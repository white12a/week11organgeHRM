package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        WebElement forgotPassLink=driver.findElement(By.xpath("//div[@id='forgotPasswordLink']/a"));// forgot link locator
        forgotPassLink.click();// click on forgot link
        WebElement forgotText=driver.findElement(By.xpath("//div[@id='wrapper']/div/div/div[2]/h1"));// text locator
        String actualText=forgotText.getText();// get text
        String expectedText="Forgot Your Password?";// expected text
        Assert.assertEquals("Forgot your password text not visible",expectedText,actualText); //validation
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
