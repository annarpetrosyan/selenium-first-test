import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pajeObjects.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
   private ChromeDriver driver;
   private LoginPage loginPage;

   @BeforeMethod
    public void setUp(){
       System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       loginPage = new LoginPage(driver);
   }

    @Test
    public void login(){
       loginPage.login("tomsmith", "SuperSecretPassword!");
        assertTrue(loginPage.isSuccessPresent(), "Login was not Sucess");
        assertTrue(loginPage.getUrl().contains("/sequre"));
        assertTrue(loginPage.getErrorMessage().contains("Your username is invalid!"), "Assertion Error");

    }

//    @Test
//    public void checkValidationMessage() throws  InterruptedException{
//        String validationMessage = "Your username is invalid!";
//        driver.findElement(By.id("username")).sendKeys("invalidUsername");
//        driver.findElement(By.id("password")).sendKeys("invalidPassword!");
//        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
//        assertTrue(driver.findElement(By.cssSelector(".flash.error")).isDisplayed());
//        assertEquals(driver.findElement(By.id("flash")).getText(),validationMessage);
//    }





   @AfterMethod
    public void tearDown(){
       driver.close();
       driver.quit();
    }
}
