import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected AuthorizationPage authorizationPage;
    protected RegistrationPage registrationPage;
    protected ProfilePage profilePage;
    protected PasswordRecoveryPage passwordRecoveryPage;

    public void startBrowserChrome() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        homePage = new HomePage(driver);
        authorizationPage = new AuthorizationPage(driver);
        registrationPage = new RegistrationPage(driver);
        profilePage = new ProfilePage(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);

    }

    public void startBrowserYandex() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        authorizationPage = new AuthorizationPage(driver);
        registrationPage = new RegistrationPage(driver);
        profilePage = new ProfilePage(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
    }



    @Before
    public void initBrowser(){
        String browser = "yandex";
        if (browser.equals("chrome")){
            startBrowserChrome();
        } else if (browser.equals("yandex")){
            startBrowserYandex();
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
