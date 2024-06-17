package Tests;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.beans.Visibility;
import java.time.Duration;

public class SideHomepageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        help.login();
    }

    @Test(priority = 10)
    public void socials() {
        String main = driver.getWindowHandle();
        for (int i = 0; i < 3; i++) {
            sideHomePage.buttons.get(i).click();
            sideHomePage.switchToNewTab();
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, sideHomePage.urls.get(i));
            driver.close();
            driver.switchTo().window(main);
        }
    }

    @Test(priority = 20)
    public void burgerContent() {
        sideHomePage.motherBurger.click();
        Assert.assertEquals(sideHomePage.burgerList.size(), 4);
    }

    @Test(priority = 30)
    public void about() {
        sideHomePage.motherBurger.click();
        sideHomePage.sideAbout.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
        driver.navigate().back();
    }

    @Test(priority = 40)
    public void loggingOut() {
        sideHomePage.motherBurger.click();
        sideHomePage.sideLogout.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test(priority = 50)
    public void closeBm()  {
        sideHomePage.motherBurger.click();
        wait.until(ExpectedConditions.visibilityOf(sideHomePage.sideLogout));
        Assert.assertTrue(sideHomePage.sideLogout.isDisplayed());
        sideHomePage.xBurger.click();
        wait.until(ExpectedConditions.invisibilityOf(sideHomePage.sideLogout));
        Assert.assertFalse(sideHomePage.sideLogout.isDisplayed());
    }

    //dodaj checkout page 1 i 2

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

