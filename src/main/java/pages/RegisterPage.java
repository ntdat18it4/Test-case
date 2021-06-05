package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private By Register = By.xpath("//*[@id=\"referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension\"]");
    private By givenName  = By.xpath("//*[@name=\"givenName\"]");
    private By familyName = By.xpath("//*[@name=\"familyName\"]");
    private By middleName = By.xpath("//*[@name=\"middleName\"]");
    private By clickNext = By.xpath("//*[@id=\"next-button\"]");
    private By birthDay = By.xpath("//*[@name=\"birthdateDay\"]");
    private By birthYear = By.xpath("//*[@name=\"birthdateYear\"]");
    private By address1 = By.xpath("//*[@id=\"address1\"]");
    private By phone = By.xpath("//*[@name=\"phoneNumber\"]");
    private By inputRl = By.xpath("//*[@id=\"relationship\"]/p[2]/input[1]");
    private By submit = By.xpath("//*[@id=\"submit\"]");
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickRegister(){
        driver.findElement(Register).click();
        return;
    }
    public void setNamePaident(String given, String mid ,String family){
        driver.findElement(givenName).sendKeys(given);
        driver.findElement(middleName).sendKeys(mid);
        driver.findElement(familyName).sendKeys(family);
    }
    public void clickNext(){
        driver.findElement(clickNext).click();
    }
    public void chooseGender(int Chon){
        driver.findElement(By.xpath("//*[@id=\"gender-field\"]/option["+Chon+"]")).click();
    }
    public void setBirth(String day,int thang, String year){
        thang += 1;
        driver.findElement(birthDay).sendKeys(day);
        driver.findElement(By.xpath("//*[@id=\"birthdateMonth-field\"]/option["+thang+"]")).click();
        driver.findElement(birthYear).sendKeys(year);
    }
    public void setAddress1(String address){
        driver.findElement(address1).sendKeys(address);
    }
    public void setPhone(String nbPhone){
        driver.findElement(phone).sendKeys(nbPhone);
    }
    public void setRelation(int rl, String input){
        driver.findElement(By.xpath("//*[@id=\"relationship_type\"]/option["+rl+"]")).click();
        driver.findElement(inputRl).sendKeys(input);
    }
    public void ClickSubmit(){
        driver.findElement(submit).click();
    }
}
