package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class LoginTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(help.sdUrl);
    }

    @Test(priority = 10)
    public void invalidLogins() {
        for (int i = 0; i < loginPage.minSize(); i++) {
            loginPage.loginForm(loginPage.badUserOrder.get(i), loginPage.badPwOrder.get(i));
            Assert.assertEquals(loginPage.getError(), loginPage.errors.get((i <= 1) ? i : 2));
            driver.navigate().refresh();
        }
    }

    @Test(priority = 20)
    public void validLogins() {
        for (String validUser : loginPage.validUsers) {
            loginPage.loginForm(validUser, loginPage.validPassword);
            Assert.assertEquals(driver.getCurrentUrl(), help.sdHomeUrl);
            help.logout();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
