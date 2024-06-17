package Tests;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SideHomepageTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        help.login();
    }

    @Test (priority = 10)
    public void socials() {
        String main = driver.getWindowHandle();
        for (int i = 0; i < 3; i++) {
            sideHomePage.buttons.get(i).click();
            sideHomePage.switchToNewTab();
            wait.until( webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, sideHomePage.urls.get(i));
            driver.close();
            driver.switchTo().window(main);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}

