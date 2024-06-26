package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SideHomePage extends BaseTest {

    //link
    public String aboutUrl = "https://saucelabs.com/";
    //socials
    @FindBy(className = "social_twitter")
    public WebElement xButton;
    @FindBy(className = "social_facebook")
    public WebElement fbButton;
    @FindBy(className = "social_linkedin")
    public WebElement lnButton;
    public List<String> urls = new ArrayList<>(Arrays.asList("https://x.com/saucelabs", "https://www.facebook.com/saucelabs", "https://www.linkedin.com/company/sauce-labs/"));

    //side stuff
    @FindBy(id = "react-burger-menu-btn")
    public WebElement motherBurger;
    @FindBy(id = "about_sidebar_link")
    public WebElement sideAbout;
    @FindBy(id = "logout_sidebar_link")
    public WebElement sideLogout;
    @FindBy(css = ".bm-item.menu-item")
    public List<WebElement> burgerList;
    @FindBy(id = "react-burger-cross-btn")
    public WebElement xBurger;
    @FindBy(id = "inventory_sidebar_link")
    public WebElement sideAll;
    @FindBy(id = "reset_sidebar_link")
    public WebElement sideReset;


    public SideHomePage() {
        PageFactory.initElements(driver, this);
    }

    //-------------------------------------------------------

    public List<WebElement> getButtons() {
        return new ArrayList<>(Arrays.asList(xButton, fbButton, lnButton));
    }

    public void switchToNewTab() {
        String main = driver.getWindowHandle();
        for (String x : driver.getWindowHandles()) {
            if (!x.equals(main)) {
                driver.switchTo().window(x);
                break;
            }
        }
    }
}
