package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By Inpatienward = By.xpath("//*[@id=\"Inpatient Ward\"]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage clickInpatient(){
        driver.findElement(Inpatienward).click();
        return new LoginPage(driver);
    }
}
