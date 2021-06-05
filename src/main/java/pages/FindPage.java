package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindPage {
    WebDriver driver;
    private By FindPatient = By.xpath("//*[@id=\"coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension\"]");
    private By TypeFind = By.xpath("//*[@id=\"patient-search\"]");
    public FindPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickFind(){
        driver.findElement(FindPatient).click();
    }
    public void find(String data){
        driver.findElement(TypeFind).sendKeys(data);
    }
}
