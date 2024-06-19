package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
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
    public void filterSortZa() {
        homePage.motherFilter.click();
        homePage.filterZa.click();
        List<String> names = new ArrayList<>();
        for (WebElement x : homePage.productNames) {
            names.add(x.getText());
        }
        for (int i = 0; i < names.size() - 1; i++) {
            Assert.assertTrue(names.get(i).compareTo(names.get(i + 1)) >= 0);
        }
    }

    @Test(priority = 80)
    public void filterSortLohi() {
        homePage.motherFilter.click();
        homePage.filterLohi.click();
        List<Double> prices = new ArrayList<>();
        for (WebElement x : homePage.productPrices) {
            prices.add(Double.parseDouble(x.getText().substring(1)));
        }
        for (int i = 0; i < prices.size() - 1; i++) {
            Assert.assertTrue(prices.get(i) <= prices.get(i+1));
        }
    }

    @Test(priority = 90)
    public void filterSortHilo() {
        homePage.motherFilter.click();
        homePage.filterHilo.click();
        List<Double> prices = new ArrayList<>();
        for (WebElement x : homePage.productPrices) {
            prices.add(Double.parseDouble(x.getText().substring(1)));
        }
        for (int i = 0; i < prices.size() - 1; i++) {
            Assert.assertTrue(prices.get(i) >= prices.get(i+1));
        }
    }

    @Test(priority = 100)
    public void filterSortAz() {
        homePage.motherFilter.click();
        homePage.filterAz.click();
        List<String> names = new ArrayList<>();
        for (WebElement x : homePage.productNames) {
            names.add(x.getText());
        }
        for (int i = 0; i < names.size() - 1; i++) {
            Assert.assertTrue(names.get(i).compareTo(names.get(i + 1)) <= 0);
        }
    }

    @Test(priority = 110)
    public void allImagesDisplayed() {
        Assert.assertEquals(homePage.getImgs().size(), 6);
        for (WebElement element : homePage.getImgs()) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
