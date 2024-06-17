package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class HomepageTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        help.login();
    }

    @Test(priority = 10)
    public void cartBadgePresent() {
        homePage.addBackpackToCart();
        Assert.assertTrue(homePage.cartBadge.isDisplayed());
        Assert.assertEquals(homePage.cartBadge.getText(), "1");
    }

    @Test(priority = 20)
    public void emptyCart() {
        homePage.removeBackpackFromCart();
        Assert.assertTrue(homePage.addBackpack.isDisplayed());
        help.toCheckout();
        Assert.assertEquals(help.total.getText(), "Total: $0.00");
        help.backToMain();
    }

    @Test(priority = 30)
    public void fullCart() {
        homePage.addAll();
        Assert.assertEquals(homePage.cartBadge.getText(), "6");
        help.toCheckout();
        Assert.assertEquals(help.total.getText(), "Total: $140.34");
    }

    @Test(priority = 40)                   //mozda odvoji check out 1 i 2 kao pages
    public void confirmOrder() {
        help.finishButton.click();
        Assert.assertEquals(help.thankYou.getText(), "Thank you for your order!");
        help.homeButton.click();
    }

    //dodaj filter i side bar page sa logout
    //images displayed



    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
