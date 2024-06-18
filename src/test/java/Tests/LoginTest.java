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
       driver.get("https://www.saucedemo.com/");

   }

   @BeforeMethod
   public void refresh() {
       driver.navigate().refresh();
   }

    @Test(priority = 10)
    public void emptyLogin() {
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getError(), loginPage.getErrorMissingCred());
    }

    @Test(priority = 20)
    public void invalidUserValidPass() {
        loginPage.loginForm("unusual_user", "secret_sauce");
        Assert.assertEquals(loginPage.getError(), loginPage.getErrorWrongCred());
    }

    @Test(priority = 30)
    public void validUserInvalidPass() {
        loginPage.loginForm("standard_user", "public_sauce");
        Assert.assertEquals(loginPage.getError(), loginPage.getErrorWrongCred());
    }

    @Test(priority = 40)
    public void invalidUserInvalidPass() {
        loginPage.loginForm("unusual_user", "public_sauce");
        Assert.assertEquals(loginPage.getError(), loginPage.getErrorWrongCred());
    }

    @Test(priority = 50)
    public void lockedOutUserValidPass() {
        loginPage.loginForm("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getError(), loginPage.getErrorLockedOut());
    }

    @Test(priority = 60)
    public void validUserValidPass()  {
       for (String validUser : loginPage.validUsers) {
           loginPage.loginForm(validUser, "secret_sauce");
           Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
           help.logout();
       }
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
