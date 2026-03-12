package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SignInSecurityPage {


    public WebElement twoFactorToggle;

    public SignInSecurityPage(){
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(xpath = "//a[text()='Profile & settings']")
        public WebElement profileSettings;

        @FindBy(xpath = "//a[text()='Sign-in & security']")
        public WebElement signInSecurity;

        @FindBy(xpath = "//button[contains(text(),'Change Password')]")
        public WebElement changePassword;

    }

