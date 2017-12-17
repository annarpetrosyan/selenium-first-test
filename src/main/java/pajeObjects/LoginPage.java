package pajeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private String baseUrl = "https://the-internet.herokuapp.com/login";
    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.cssSelector("#login button");
    private By successLocator = By.cssSelector(".flash.success");
    private By errorLocator = By.cssSelector(".flash.error");
// This

    public LoginPage(WebDriver webDriver){
       this.driver=webDriver;
       driver.get(baseUrl);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
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


    public String getErrorMessage() {
        return driver.findElement(errorLocator).getText();
    }
    // Home task
    // this is fill method
    public void fill(String fieldName, String value) {
        switch (fieldName) {
            case "Username": {
                driver.findElement(usernameLocator).sendKeys(value);
                break;
            }
            case "Password": {
                driver.findElement(passwordLocator).sendKeys(value);
                break;
            }
            default: {
                System.out.println("There is no" + fieldName + " field!");
            }
        }
    }
    /*
        This is click function
    */
    public void clickOn(String buttonName){
        switch(buttonName){
            case "Login":{
                driver.findElement(loginButtonLocator).click();
                break;
            }
            default:{
                System.out.println("There is no" + buttonName + " button!");
            }
        }
    }
//    public boolean isSuccessPresent(){
//        return driver.findElement(successLocator).isDisplayed();
//    }
//
//    public boolean isErrorPresent(){
//        return driver.findElement(errorLocator).isDisplayed();
//
//    }
/*
Global function for isDisplayed
 */



}
