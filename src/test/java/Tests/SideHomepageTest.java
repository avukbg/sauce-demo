package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SideHomepageTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        help.login();
    }

    @Test
    public void socials () {

    }
}
