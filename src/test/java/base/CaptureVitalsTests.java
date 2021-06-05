package base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CapturePage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class CaptureVitalsTests {
    WebDriver driver;
    HomePage homePage;

    @Test
    @DisplayName("TC10-Capture Vitals for a Paitent is Succesfully.")
    public void CaptureSuccess() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginSuccess();
        CapturePage capturePage = new CapturePage(driver);
        capturePage.ClickCap();
        capturePage.ChoosePaitent(1);
        capturePage.YesRecord();
        capturePage.setHeight("190");
        capturePage.ClikNext();
        capturePage.setWeight("90");
        capturePage.ClikNext();
        capturePage.ClikNext();
        capturePage.setTemperature("37");
        capturePage.ClikNext();
        capturePage.setPulse("85");
        capturePage.ClikNext();
        capturePage.setRespiratory("17");
        capturePage.ClikNext();
        capturePage.setBlood("120","80");
        capturePage.ClikNext();
        capturePage.setOxygen("95");
        capturePage.ClikNext();
        capturePage.ClickSave();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"patient-search\"]")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }
}
