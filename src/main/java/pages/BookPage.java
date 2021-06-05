package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BookPage {
    WebDriver driver;
    private By clickAppoint = By.xpath("//*[@id=\"appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension\"]");
    private By clickProvider = By.xpath("//*[@id=\"appointmentschedulingui-scheduleProviders-app\"]");
    private By chooseDay = By.xpath("//*[@id=\"calendar\"]/div/div/table/tbody/tr[3]/td[2]");
    private By openLocation = By.xpath("//*[@id=\"select-location\"]/select");
    private By chooseLocation = By.xpath("//*[@id=\"select-location\"]/select/option[3]");
    private By provider = By.xpath("//*[@id=\"select-provider\"]/input");
    private By StartHours = By.xpath("//*[@id=\"start-time\"]/table/tbody/tr[2]/td[1]/input");
    private By StartMinutes = By.xpath("//*[@id=\"start-time\"]/table/tbody/tr[2]/td[3]/input");
    private By EndHours = By.xpath("//*[@id=\"end-time\"]/table/tbody/tr[2]/td[1]/input");
    private By EndMinutes = By.xpath("//*[@id=\"end-time\"]/table/tbody/tr[2]/td[3]/input");
    private By viewAllType = By.xpath("//*[@id=\"appointment-block-form\"]/selectmultipleappointmenttypes/div/div[1]/div[2]/a");
    private By clickToShowSelect = By.xpath("//*[@id=\"modal-overlay\"]");
    private By arrChooseService = By.xpath("//*[@class=\"ng-binding\"]");
    private By closeChooseService = By.xpath("//*[@id=\"allAppointmentTypesModal\"]/div[2]/span");
    private By save = By.xpath("//*[@id=\"appointment-block-form-buttons\"]/button[2]");
    public BookPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ClickAppoint(){
        driver.findElement(clickAppoint).click();
    }
    public void ClickProvider(){
        driver.findElement(clickProvider).click();
    }
    public void ChooseDay(){
        driver.findElement(chooseDay).click();
    }
    public void ChooseLocation() throws InterruptedException {
        driver.findElement(openLocation).click();
        Thread.sleep(100);
        driver.findElement(chooseLocation).click();
    }
    public void setProvider(String pro){
        driver.findElement(provider).sendKeys(pro);
    }
    public void SetTimeStart(String hours, String minutes)  {
        Actions actions = new Actions(driver);
        actions.doubleClick( driver.findElement(StartHours)).perform();
        driver.findElement(StartHours).sendKeys(hours);
        actions.doubleClick( driver.findElement(StartMinutes)).perform();
        driver.findElement(StartMinutes).sendKeys(minutes);

    }
    public void SetTimeEnd(String hours, String minutes){
        Actions actions = new Actions(driver);
        actions.doubleClick( driver.findElement(EndHours)).perform();
        driver.findElement(EndHours).sendKeys(hours);
        actions.doubleClick( driver.findElement(EndMinutes)).perform();
        driver.findElement(EndMinutes).sendKeys(minutes);
    }
    public void ChooseService() throws InterruptedException {
        driver.findElement(viewAllType).click();
        Thread.sleep(500);
        WebElement nay = driver.findElement(clickToShowSelect);
        nay.click();
        List<WebElement> listchoose = driver.findElements(arrChooseService);
        System.out.println(listchoose.size());
        listchoose.get(74).click();
        listchoose.get(76).click();
        List<WebElement> listclose = driver.findElements(closeChooseService);
        listclose.get(1).click();
    }
    public void ClickSave(){
        driver.findElement(save).click();
    }
}
