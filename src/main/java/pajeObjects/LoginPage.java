package pajeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    private WebDriver driver;
    private String baseUrl = "https://the-internet.herokuapp.com/login";
    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.cssSelector("#login button");
    private By successLocator = By.cssSelector(".flash.success");
    private By errorLocator = By.cssSelector(".flash.error");

    public LoginPage(WebDriver webDriver){
       this.driver=webDriver;
       driver.get(baseUrl);
    }

    public void login(String username, String password){
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public boolean isSuccessPresent(){
        return driver.findElement(successLocator).isDisplayed();
    }

    public boolean isErrorPresent(){
        return driver.findElement(errorLocator).isDisplayed();

    }
}
