package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SideHomePage extends BaseTest {

    public SideHomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class='footer']")
    public List <WebElement> socialList;



    //-------------------------------------------------------

}
