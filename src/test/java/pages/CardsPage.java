package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CardsPage {
    WebDriver driver = Driver.getDriver();

    public CardsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header[@class='bg-nav w-full']//a[text()='Cards']")
    public WebElement cardsLink;

    @FindBy(xpath = "//h2[contains(.,'Cards')]")
    public WebElement header;

    @FindBy(xpath = "(//div[text()='Active'])[1]")
    public WebElement activeCard;

    @FindBy(xpath = "//div[@role='dialog']")
    public WebElement balanceInfo;

    @FindBy(xpath = "(//p[text()='CARD HOLDER'])[1]/following-sibling::p")
    public WebElement cardHolderName;

    @FindBy(xpath = "//div[@role='dialog']//p[text()='Card Holder']/following-sibling::p")
    public WebElement cardHolderNameInfo;

    @FindBy(xpath = "//div[@role='dialog']//button[@type='button']")
    public WebElement closeBalanceInfoButton;

    @FindBy (xpath = "(//p[@class='font-mono text-lg tracking-widest text-nav-foreground mb-3'])[1]")
    public WebElement maskedCardNumber;

    @FindBy (xpath = "(//button[.//*[name()='svg' and contains(@class,'eye')]])[1]")
    public WebElement eyeButton;


}