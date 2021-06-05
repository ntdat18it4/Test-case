package base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests {
    WebDriver driver;
    HomePage homePage;

    @Test
    @DisplayName("TC01-Verify User is able to login with CORRECT User Id and Password and choose Location is Inpatient Ward")
    public void loginSuceessfully() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickInpatient();
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickLoginButton();

        WebElement alert = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/h4"));
        System.out.println(alert.getText());
        Assertions.assertTrue(alert.getText().equals("Logged in as Super User (admin) at Inpatient Ward."), "Login is correct");
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    @DisplayName("TC02-Verify User is able to login with CORRECT User Id and Password but not choosing location ")
    public void loginWithoutLocation() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickLoginButton();

        WebElement alert = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/p[3]/label"));
        System.out.println(alert.getText());
        Assertions.assertTrue(alert.getText().contains("You must choose a location!"), "Much choose location");
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    @DisplayName("TC03-Verify User is able to login with INCORRECT User Id and Password")
    public void loginFail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickInpatient();
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin");
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"loginButton\"]"))));
        WebElement alert = driver.findElement(By.xpath("//*[@id=\"error-message\"]"));
        System.out.println(alert.getText());
        Assertions.assertTrue(alert.getText().equals("Invalid username/password. Please try again."), "Login is incorrect");
        Thread.sleep(2000);
        driver.quit();
    }

}
