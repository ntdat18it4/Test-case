package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userNametxt = By.id("username");
    private By passwordtxt = By.id("password");
    private By loginButton = By.id("loginButton");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUserName(String userName){
        driver.findElement(userNametxt).sendKeys(userName);
    }
    public void  setPassword(String password){
        driver.findElement(passwordtxt).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
        return ;
    }
    public void LoginSuccess(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickInpatient();
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickLoginButton();

    }
}
