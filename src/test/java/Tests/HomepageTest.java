package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class HomepageTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        help.login();
    }

    @Test(priority = 10)
    public void addAllButtons() {
        homePage.addAll();
        for (WebElement x : homePage.removeButtons) {
            Assert.assertTrue(x.isDisplayed());
        }
    }

    @Test(priority = 20)
    public void cartBadgePresent() {
        Assert.assertTrue(homePage.cartBadge.isDisplayed());
        Assert.assertEquals(homePage.cartBadge.getText(), "6");
    }


    @Test(priority = 30)
    public void fullCart() {
        help.toCheckout();
        Assert.assertEquals(help.total.getText(), "Total: $140.34");
    }

    @Test(priority = 40)
    public void confirmOrder() {
        help.finishButton.click();
        Assert.assertEquals(help.thankYou.getText(), "Thank you for your order!");
        help.homeButton.click();
    }

    @Test(priority = 50)
    public void removeAllButtons() {
        homePage.addAll();
        homePage.removeAll();
        for (WebElement x : homePage.addButtons) {
            Assert.assertTrue(x.isDisplayed());
        }
    }

    @Test(priority = 60)
    public void emptyCart() {
        help.toCheckout();
        Assert.assertEquals(help.total.getText(), "Total: $0.00");
        help.backToMain();
    }

    @Test(priority = 70)
    public void sorting() {
        for (int i = 0; i < homePage.sortOptions().size(); i++) {
            homePage.motherFilter.click();
            homePage.sortOptions().get(i).click();
            if (i < 2) {
                List<String> names = homePage.getNames();
                for (int j = 0; j < homePage.itemCount - 1; j++) {
                    Assert.assertTrue((i == 0) ? names.get(j).compareTo(names.get(j + 1)) >= 0 : names.get(j).compareTo(names.get(j + 1)) <= 0);
                }
            } else {
                List<Double> prices = homePage.getPrices();
                for (int j = 0; j < homePage.itemCount - 1; j++) {
                    Assert.assertTrue((i == 2) ? prices.get(j) <= prices.get(j + 1) : prices.get(j) >= prices.get(j + 1));
                }
            }
        }
    }


    @Test(priority = 80)
    public void allImagesDisplayed() {
        Assert.assertEquals(homePage.getImages().size(), 6);
        for (WebElement x : homePage.getImages()) {
            Assert.assertTrue(x.isDisplayed());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
