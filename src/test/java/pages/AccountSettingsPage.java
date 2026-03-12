package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AccountSettingsPage {

    public AccountSettingsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Account settings')]")
    public WebElement accountSettings;

    @FindBy(xpath = "//input[@type='checkbox'][1]")
    public WebElement goPaperlessToggle;

    @FindBy(xpath = "//input[contains(@value,'My Account')]")
    public WebElement accountNickname;

    @FindBy(xpath = "//input[@type='checkbox'][2]")
    public WebElement hideAccountToggle;

}
