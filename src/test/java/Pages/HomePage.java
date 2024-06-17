package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    @FindBy(className = "shopping_cart_link")
    public WebElement cart;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addBackpack;
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeBackpack;
    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> addButtons;

    //filter

    @FindBy(className = "product_sort_container")
    public WebElement motherFilter;
    @FindBy(css = "[value='za']")
    public WebElement filterZa;
    @FindBy(css = "[value='lohi']")
    public WebElement filterLohi;
    @FindBy(css = "[value='hilo']")
    public WebElement filterHilo;
    @FindBy(css = "[value='az']")
    public WebElement filterAz;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> productNames;
    @FindBy(className = "inventory_item_price")
    public List<WebElement> productPrices;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //------------------------------------------------------------------

    public void addBackpackToCart() {
        addBackpack.click();
    }

    public void removeBackpackFromCart() {
        removeBackpack.click();
    }

    public void addAll() {
        for (WebElement x : addButtons) {
            x.click();
        }
    }

}
