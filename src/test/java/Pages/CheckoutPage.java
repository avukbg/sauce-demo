package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {

    @FindBy(className = "inventory_item_price")
    public WebElement priceOne;
    @FindBy(id = "continue-shopping")
    public WebElement backOne;
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeBpOne;
    @FindBy(id = "cancel")
    public WebElement cancelTwo;

    //linkovi

    public String checkOutOneUrl = "https://www.saucedemo.com/checkout-step-one.html";
    public String cartUrl = "https://www.saucedemo.com/cart.html";

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    //-----------------------------------------------

}
