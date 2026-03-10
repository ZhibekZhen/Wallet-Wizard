package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseUI;
import utils.Driver;

public class LoginPage extends BaseUI {
    WebDriver driver = Driver.getDriver();

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[type='email']")
    public WebElement loginInput;

    @FindBy(css = "input[type='password']")
    public WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//button[text()='Sign out']")
    public WebElement signOutButton;

    public void login() {
        for (int i = 1; i <= 2; i++) {
            waitAndSendKeys(loginInput, "testuser" + i + "@vaultbank.test");
            waitAndSendKeys(passwordInput, "Test" + i + "Pass!");
            waitAndClick(signInButton);

            explicitWait(5).until(ExpectedConditions.elementToBeClickable(signOutButton));
            waitAndClick(signOutButton);
        }
    }

    public void loginAndStay() {
            waitAndSendKeys(loginInput, "testuser1@vaultbank.test");
            waitAndSendKeys(passwordInput, "Test1Pass!");
            waitAndClick(signInButton);
    }
}

