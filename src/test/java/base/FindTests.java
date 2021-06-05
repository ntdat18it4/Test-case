package base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FindPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class FindTests {
    WebDriver driver;
    HomePage homePage;
    @Test
    @DisplayName("TC06-Find record by ID when that ID available.")
    public void FindPatientByID() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginSuccess();
        FindPage findPage = new FindPage(driver);
        findPage.clickFind();
        findPage.find("100");
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patient-search-results-table\"]")));
        System.out.println(driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr[1]/td[1]")).getText());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    @DisplayName("TC07-Find record by Name when that Name available.")
    public void FindPatientByName() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginSuccess();
        FindPage findPage = new FindPage(driver);
        findPage.clickFind();
        findPage.find("Nguyen Thanh Dat");
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("spinner"))));
        Thread.sleep(2000);
        driver.quit();
    }
}
