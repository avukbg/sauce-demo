package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Help extends BaseTest {

    public Help() {
        PageFactory.initElements(driver, this);
    }


    //boring form stuff
    @FindBy(className = "shopping_cart_link")
    public WebElement cart;
    @FindBy(id = "checkout")
    public WebElement checkoutButton;
    @FindBy(id = "first-name")
    public WebElement formName;
    @FindBy(id = "last-name")
    public WebElement formLastname;
    @FindBy(id = "postal-code")
    public WebElement formPost;
    @FindBy(id = "continue")
    public WebElement formContinue;

    //checkout

    @FindBy(className = "summary_total_label")
    public WebElement total;
    @FindBy(id = "finish")
    public WebElement finishButton;
    @FindBy(className = "complete-header")
    public WebElement thankYou;
    @FindBy(id = "back-to-products")
    public WebElement homeButton;

    //--------------------------------------------------------------------------

    //tranzicije

    public void toCheckout() {
        cart.click();
        checkoutButton.click();
        formName.sendKeys("Tikvica");
        formLastname.sendKeys("Jagoda");
        formPost.sendKeys("11000");
        formContinue.click();
    }

    public void backToMain() {
        finishButton.click();
        homeButton.click();
    }

    //---------------------------------------------------------------------------
    //login
    public void login() {
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
