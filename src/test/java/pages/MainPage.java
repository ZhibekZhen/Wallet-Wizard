package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (linkText = "Accounts")
    public WebElement accountsSection;

    @FindBy (linkText = "Customer Insights")
    public WebElement customerInsightsSection;

    @FindBy (linkText = "Pay & transfer")
    public WebElement payAndTransferSection;

    @FindBy (linkText = "Statements & documents")
    public WebElement statementsAndDocumentsSection;

    @FindBy (linkText = "Cards")
    public WebElement cardsSection;

    @FindBy (linkText = "Profile & settings")
    public WebElement profileAndSettingsSection;

    @FindBy (xpath = "//span[@class='text-sm text-nav-foreground/70']")
    public WebElement userEmailDisplayed;

    @FindBy (xpath = "//button[text()='Sign out']")
    public WebElement signOutBtn;








}
