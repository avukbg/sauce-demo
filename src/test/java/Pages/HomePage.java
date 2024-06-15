package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    @FindBy(className = "shopping_cart_link")
    public WebElement Cart;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement AddBackpack;
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement RemoveBackpack;
    @FindBy(className = "shopping_cart_badge")
    public WebElement CartBadge;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List <WebElement> AddButtons;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //------------------------------------------------------------------

    public void addBackpackToCart() {
        AddBackpack.click();
    }

    public void removeBackpackFromCart() {
        RemoveBackpack.click();
    }

    public void addAll() {
        for (WebElement x : AddButtons) {
            x.click();
        }
    }




}
