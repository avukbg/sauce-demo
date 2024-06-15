package Tests;

import Base.BaseTest;
import Pages.Help;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class HomepageTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Help.login();
    }

    @Test(priority = 10)
    public void cartBadgePresent() {
        homePage.addBackpackToCart();
        Assert.assertTrue(homePage.CartBadge.isDisplayed());
        Assert.assertEquals(homePage.CartBadge.getText(), "1");
    }

    @Test(priority = 20)
    public void emptyCart() {
        homePage.removeBackpackFromCart();
        Assert.assertTrue(homePage.AddBackpack.isDisplayed());
        help.toCheckout();
        Assert.assertEquals(help.Total.getText(), "Total: $0.00");
        help.backToMain();
    }

    @Test(priority = 30)
    public void fullCart() {
        homePage.addAll();
        Assert.assertEquals(homePage.CartBadge.getText(), "6");
        help.toCheckout();
        Assert.assertEquals(help.Total.getText(), "Total: $140.34");
    }

    @Test(priority = 40)                   //mozda odvoji check out 1 i 2 kao pages
    public void confirmOrder() {
        help.FinishButton.click();
        Assert.assertEquals(help.ThankYou.getText(), "Thank you for your order!");
        help.HomeButton.click();
    }


    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
