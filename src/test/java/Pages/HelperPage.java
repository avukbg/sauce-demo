package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelperPage extends BaseTest {

    public HelperPage() {
        PageFactory.initElements(driver, this);
    }


    //boring form stuff
    @FindBy(className = "shopping_cart_link")
    public WebElement Cart;
    @FindBy(id = "checkout")
    public WebElement CheckoutButton;
    @FindBy(id = "first-name")
    public WebElement FormName;
    @FindBy(id = "last-name")
    public WebElement FormLastname;
    @FindBy(id = "postal-code")
    public WebElement FormPost;
    @FindBy(id = "continue")
    public WebElement FormContinue;

    //checkout

    @FindBy(className = "summary_total_label")
    public WebElement Total;
    @FindBy(id = "finish")
    public WebElement FinishButton;
    @FindBy(className = "complete-header")
    public WebElement ThankYou;
    @FindBy(id = "back-to-products")
    public WebElement HomeButton;

    //--------------------------------------------------------------------------

    //tranzicije

    public void toCheckout() {
        Cart.click();
        CheckoutButton.click();
        FormName.sendKeys("Tikvica");
        FormLastname.sendKeys("Jagoda");
        FormPost.sendKeys("11000");
        FormContinue.click();
    }

    public void backToMain() {
        FinishButton.click();
        HomeButton.click();
    }

    //---------------------------------------------------------------------------
    //login
    public static void login() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("password")).submit();
    }

  /*  public static void miniSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }*/

    //maybe

    /*public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("", element);
    }

    public void waitForElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }*/
}
