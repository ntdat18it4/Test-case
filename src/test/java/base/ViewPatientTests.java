package base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FindPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class ViewPatientTests {
    WebDriver driver;
    HomePage homePage;
    @Test
    @DisplayName("TC08-View a patient first on the list")
    public void ViewPatient() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginSuccess();
        FindPage findPage = new FindPage(driver);
        findPage.clickFind();
        driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"coreapps-diagnosesList\"]/div[2]")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.quit();
    }
}
