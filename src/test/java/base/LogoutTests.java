package base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTests {
    WebDriver driver;
    HomePage homePage;
    @Test
    @DisplayName("TC04-Verify if you have logged out to the login screen.")
    public void LogOut() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginSuccess();
        WebElement btnLogout = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]"));
        btnLogout.click();
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.equals("https://demo.openmrs.org/openmrs/login.htm"),"Log out successfully");
        Thread.sleep(2000);
        driver.quit();
    }
}
