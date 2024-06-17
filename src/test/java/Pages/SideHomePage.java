package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SideHomePage extends BaseTest {
    public SideHomePage() {PageFactory.initElements(driver, this);
        buttons = new ArrayList<>(Arrays.asList(xButton, fbButton, lnButton));
    }

    @FindBy(className = "social_twitter")
    public WebElement xButton;
    @FindBy(className = "social_facebook")
    public WebElement fbButton;
    @FindBy(className = "social_linkedin")
    public WebElement lnButton;

    public List <WebElement> buttons;
    public List <String> urls = new ArrayList<>(Arrays.asList("https://x.com/saucelabs","https://www.facebook.com/saucelabs","https://www.linkedin.com/company/sauce-labs/"));

    //-------------------------------------------------------

    public void switchToNewTab() {
        String mainHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
