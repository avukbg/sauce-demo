package Base;

import Pages.Help;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SideHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public HomePage homePage;
    public Help help;
    public SideHomePage sideHomePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage();
        homePage = new HomePage();
        help = new Help();
        sideHomePage = new SideHomePage();
    }
}




