package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage extends BaseTest {

    @FindBy(id = "user-name")
    public WebElement usernameField;
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(id = "login-button")
    public WebElement loginButton;
    @FindBy(css = "[data-test='error']")
    public WebElement errorBox;
    public List<String> validUsers = new ArrayList<>(Arrays.asList("standard_user", "problem_user", "performance_glitch_user", "error_user", "visual_user"));

    //login 2 exp

    public String errorMissingCred = "Epic sadface: Username is required";
    public String errorLockedOut = "Epic sadface: Sorry, this user has been locked out.";
    public String errorWrongCred = "Epic sadface: Username and password do not match any user in this service";
    public List<String> errors = new ArrayList<>(Arrays.asList(errorMissingCred, errorLockedOut, errorWrongCred));

    public String validPassword = "secret_sauce";
    public String invalidPassword = "public_sauce";
    public List<String> badPwOrder = new ArrayList<>(Arrays.asList("", validPassword,  invalidPassword, validPassword, invalidPassword));
                                                                // sa 3  (i%2==1) ? 1 : (i==0 ? 0 : 2)
    public String loUser = "locked_out_user";
    public String validUser = "standard_user";
    public String invalidUser = "unusual_user";
    public List<String> badUserOrder = new ArrayList<>(Arrays.asList("", loUser,  validUser, invalidUser, invalidUser));
                                                                // sa 4  (i>2) ? 3 : i

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    //----------------------------

    public void inputUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void loginForm(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickOnLoginButton();
    }

    public String getError() {
        return errorBox.getText();
    }
}