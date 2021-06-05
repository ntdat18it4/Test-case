package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CapturePage {
    WebDriver driver;
    private By clickCap = By.xpath("//*[@id=\"referenceapplication-vitals-referenceapplication-vitals-extension\"]");
    private By yesRecord = By.xpath("//*[@id=\"coreapps-vitals-confirm\"]");
    private By btnNext = By.xpath("//*[@id=\"next-button\"]");
    private By height = By.xpath("//*[@id=\"w8\"]");
    private By weight = By.xpath("//*[@id=\"w10\"]");
    private By temperature = By.xpath("//*[@id=\"w12\"]");
    private By pulse = By.xpath("//*[@id=\"w14\"]");
    private By respiratory = By.xpath("//*[@id=\"w16\"]");
    private By preblood = By.xpath("//*[@id=\"w18\"]");
    private By afterblood = By.xpath("//*[@id=\"w20\"]");
    private By oxygen = By.xpath("//*[@id=\"w22\"]");
    private By btnSave = By.xpath("//*[@id=\"confirmationQuestion\"]/p[1]/button");
    private int i = 1;
    public CapturePage(WebDriver driver) {
        this.driver = driver;
    }
    public void ClickCap(){
        driver.findElement(clickCap).click();
    }
    public void ChoosePaitent(int id){
        driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr["+id+"]")).click();
    }
    public boolean checkExist(){
        try {
           driver.findElement(yesRecord);
           return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public void YesRecord(){
       if(this.checkExist()) {
           driver.findElement(yesRecord).click();
       }else {
           i+=1;
           driver.navigate().back();
           this.ChoosePaitent(i);
           this.YesRecord();
       }
    }
    public void ClikNext(){
        driver.findElement(btnNext).click();
    }
    public void setHeight(String h){
        driver.findElement(height).sendKeys(h);
    }
    public void setWeight(String w){
        driver.findElement(weight).sendKeys(w);
    }
    public void setTemperature(String t){
        driver.findElement(temperature).sendKeys(t);
    }
    public void setPulse(String p){
        driver.findElement(pulse).sendKeys(p);
    }
    public void setRespiratory(String r){
        driver.findElement(respiratory).sendKeys(r);
    }
    public void setBlood(String pre, String after){
        driver.findElement(preblood).sendKeys(pre);
        driver.findElement(afterblood).sendKeys(after);
    }
    public void setOxygen(String o){
        driver.findElement(oxygen).sendKeys(o);
    }
    public void ClickSave(){
        driver.findElement(btnSave).click();
    }
}
