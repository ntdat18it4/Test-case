package base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookPage;
import pages.HomePage;
import pages.LoginPage;

public class BookApTests {
    WebDriver driver;
    HomePage homePage;

    @Test
    @DisplayName("TC09-Booking an Appointment is Succesfully.")
    public void BookAppointment() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginSuccess();
        BookPage bookPage = new BookPage(driver);
        bookPage.ClickAppoint();
        bookPage.ClickProvider();
        bookPage.ChooseDay();
        bookPage.ChooseLocation();
        bookPage.setProvider("Dat");
        bookPage.SetTimeStart("10","40");
        bookPage.SetTimeEnd("12","30");
        bookPage.ChooseService();
        bookPage.ClickSave();
        Thread.sleep(2000);
        driver.quit();
    }
}
