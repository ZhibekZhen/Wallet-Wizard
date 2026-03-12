package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUI;
import utils.Driver;

public class AccountsPage extends BaseUI {
    WebDriver driver = Driver.getDriver();

    public AccountsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//header[@class='bg-nav w-full']//a[text()='Accounts']")
    public WebElement accountsLink;

    @FindBy (xpath = "//h2[contains(.,'Good afternoon')]")
    public WebElement header;

    @FindBy (xpath = "//button[@role='combobox']")
    public WebElement allAccountsDropdown;

    @FindBy (xpath = "//span[text()='Credit']")
    public WebElement creditOption;

    @FindBy (xpath = "//button[contains(., 'CREDIT')]")
    public WebElement creditAccount;

    @FindBy (xpath = "//button[text()='View Statements']")
    public WebElement viewStatements;

    @FindBy (xpath = "//button[text()='Transfer Money']")
    public WebElement transferMoneyButton;

    @FindBy (xpath = "//button[contains(., 'SAVINGS')]/following-sibling::div/button[text()='Transfer money']")
    public WebElement moreSavingsDropdown;

    @FindBy (partialLinkText = " Set savings goal")
    public WebElement setSavingsGoalOption;

    ////button[text()='Transfer money']


}
