package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChekoutOnePage extends BaseTest {

    @FindBy(className = "inventory_item_price")
    public WebElement priceOne;
    @FindBy(id = "continue-shopping")
    public WebElement backOne;
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeBpOne;
    public ChekoutOnePage() {
        PageFactory.initElements(driver, this);
    }

    //-----------------------------------------------


}
