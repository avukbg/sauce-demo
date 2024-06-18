package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutOneTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        help.login();
    }

    @Test (priority = 91)
    public void priceOne() {
        homePage.addBackpackToCart();
        homePage.cart.click();
        Assert.assertEquals(checkoutOnePage.priceOne.getText(), "$29.99");
    }

    @Test(priority = 92)
    public void removeOne() {
        checkoutOnePage.removeBpOne.click();
        help.smallCheckout();
        Assert.assertEquals(help.total.getText(), "Total: $0.00");
        help.backToMain();
    }

    @Test(priority = 93)
    public void continueOne() {
        homePage.cart.click();
        checkoutOnePage.backOne.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 94)
    public void finishOne() {
        homePage.cart.click();
        help.checkoutButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
