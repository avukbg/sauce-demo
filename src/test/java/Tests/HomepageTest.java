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
    public void addAll() {
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
    public void removeAll() {
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
        List<String> scrapedNames = new ArrayList<>();
        for (WebElement element : homePage.productNames) {
            scrapedNames.add(element.getText().trim());
        }
        for (int i = 0; i < scrapedNames.size() - 1; i++) {
            String currentName = scrapedNames.get(i);
            String nextName = scrapedNames.get(i + 1);
            Assert.assertTrue(currentName.compareTo(nextName) >= 0);
        }
    }

    @Test(priority = 80)
    public void filterSortLohi() {
        homePage.motherFilter.click();
        homePage.filterLohi.click();
        List<String> scrapedPrices = new ArrayList<>();
        for (WebElement element : homePage.productPrices) {
            scrapedPrices.add(element.getText().trim().replace("$", ""));
        }
        for (int i = 0; i < scrapedPrices.size() - 1; i++) {
            double currentPrice = Double.parseDouble(scrapedPrices.get(i));
            double nextPrice = Double.parseDouble(scrapedPrices.get(i + 1));
            Assert.assertTrue(currentPrice <= nextPrice);
        }
    }

    @Test(priority = 90)
    public void filterSortHilo() {
        homePage.motherFilter.click();
        homePage.filterHilo.click();
        List<String> scrapedPrices = new ArrayList<>();
        for (WebElement element : homePage.productPrices) {
            scrapedPrices.add(element.getText().trim().replace("$", ""));
        }
        for (int i = 0; i < scrapedPrices.size() - 1; i++) {
            double currentPrice = Double.parseDouble(scrapedPrices.get(i));
            double nextPrice = Double.parseDouble(scrapedPrices.get(i + 1));
            Assert.assertTrue(currentPrice >= nextPrice);
        }
    }

    @Test(priority = 100)
    public void filterSortAz() {
        homePage.motherFilter.click();
        homePage.filterAz.click();
        List<String> scrapedNames = new ArrayList<>();
        for (WebElement element : homePage.productNames) {
            scrapedNames.add(element.getText().trim());
        }
        for (int i = 0; i < scrapedNames.size() - 1; i++) {
            String currentName = scrapedNames.get(i);
            String nextName = scrapedNames.get(i + 1);
            Assert.assertTrue(currentName.compareTo(nextName) <= 0);
        }
    }

    @Test(priority = 110)
    public void allImages() {
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
