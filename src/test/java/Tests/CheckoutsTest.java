package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutsTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        help.login();
    }

    @Test(priority = 10)
    public void isPriceDisplayedOne() {
        homePage.addBackpackToCart();
        homePage.cart.click();
        Assert.assertEquals(checkoutPage.priceOne.getText(), "$29.99");
    }

    @Test(priority = 20)
    public void removeButtonOne() {
        checkoutPage.removeBpOne.click();
        help.smallCheckout();
        Assert.assertEquals(help.total.getText(), "Total: $0.00");
        help.backToMain();
    }

    @Test(priority = 30)
    public void continueShoppingButtonOne() {
        homePage.cart.click();
        checkoutPage.backOne.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 40)
    public void finishButtonOne() {
        homePage.cart.click();
        help.checkoutButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
    }

    @Test(priority = 50)
    public void cancelButtonTwo() {
        checkoutPage.cancelTwo.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }

    @Test(priority = 60)
    public void finalCancelButtonThree() {
        sideHomePage.motherBurger.click();
        sideHomePage.sideAll.click();
        help.toCheckout();
        checkoutPage.cancelTwo.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
