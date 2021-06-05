package base;

public class MainTests {


    public static void main (String[] args) throws InterruptedException {
     
        LoginTests loginTests = new LoginTests();
        RegisterTests registerTests = new RegisterTests();
        LogoutTests logoutTests = new LogoutTests();
        FindTests findTests = new FindTests();
        ViewPatientTests viewTest = new ViewPatientTests();
        BookApTests bookApTests = new BookApTests();
        CaptureVitalsTests captureVitalsTests = new CaptureVitalsTests();

        loginTests.loginSuceessfully();
        Thread.sleep(1000);
        loginTests.loginWithoutLocation();
        Thread.sleep(1000);
        loginTests.loginFail();
        Thread.sleep(1000);
        logoutTests.LogOut();
        Thread.sleep(1000);
        registerTests.RegisterPainter();
        Thread.sleep(1000);
        findTests.FindPatientByID();
        Thread.sleep(1000);
        findTests.FindPatientByName();
        Thread.sleep(1000);
        viewTest.ViewPatient();
        Thread.sleep(1000);
        bookApTests.BookAppointment();
        Thread.sleep(1000);
        captureVitalsTests.CaptureSuccess();
    }
}
