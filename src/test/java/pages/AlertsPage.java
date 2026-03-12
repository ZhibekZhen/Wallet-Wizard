package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.HashMap;
import java.util.Map;

public class AlertsPage {

    public Map<String, WebElement> alertsButtons;

    public AlertsPage() {
        PageFactory.initElements(Driver.getDriver(), this);

        alertsButtons = new HashMap<>();
        alertsButtons.put("Transaction Alerts", transactionAlertsBtn);
        alertsButtons.put("Low Balance Alerts", lowBalanceAlertsBtn);
        alertsButtons.put("Monthly Statements", monthlyStatementsBtn);
    }

    @FindBy(xpath = "//p[text()='Transaction Alerts']/../..//button")
    public WebElement transactionAlertsBtn;

    @FindBy(xpath = "//p[text()='Low Balance Alerts']/../..//button")
    public WebElement lowBalanceAlertsBtn;

    @FindBy(xpath = "//p[text()='Monthly Statements']/../..//button")
    public WebElement monthlyStatementsBtn;

    @FindBy(xpath = "//span[text()='Alerts']/..")
    public WebElement alertsSection;



}
