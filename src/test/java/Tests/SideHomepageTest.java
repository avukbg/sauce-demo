package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class SideHomepageTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        help.login();
    }

    @Test(priority = 10)
    public void socials() {
        String main = driver.getWindowHandle();

        for (int i = 0; i < 3; i++) {
            sideHomePage.getButtons().get(i).click();
            sideHomePage.switchToNewTab();
            //wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            wait.until(ExpectedConditions.urlToBe(sideHomePage.urls.get(i)));
            Assert.assertEquals(driver.getCurrentUrl(), sideHomePage.urls.get(i));
            driver.close();
            driver.switchTo().window(main);
        }
    }

    @Test(priority = 20)
    public void bmContent() {
        sideHomePage.motherBurger.click();
        Assert.assertEquals(sideHomePage.burgerList.size(), 4);
    }

    @Test(priority = 30)
    public void bmAbout() {
        sideHomePage.sideAbout.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
        driver.navigate().back();
    }

    @Test(priority = 40)
    public void bmAllItems() {
        homePage.cart.click();
        sideHomePage.motherBurger.click();
        sideHomePage.sideAll.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 50)
    public void bmResetState() {
        homePage.addBackpackToCart();
        sideHomePage.motherBurger.click();
        sideHomePage.sideReset.click();
        help.toCheckout();
        Assert.assertEquals(help.total.getText(), "Total: $0.00");
    }

    @Test(priority = 60)
    public void bmClose() {
        sideHomePage.motherBurger.click();
        wait.until(ExpectedConditions.visibilityOf(sideHomePage.sideLogout));
        Assert.assertTrue(sideHomePage.sideLogout.isDisplayed());
        sideHomePage.xBurger.click();
        wait.until(ExpectedConditions.invisibilityOf(sideHomePage.sideLogout));
        Assert.assertFalse(sideHomePage.sideLogout.isDisplayed());
    }

    @Test(priority = 70)
    public void bmLoggingOut() {
        sideHomePage.motherBurger.click();
        sideHomePage.sideLogout.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

