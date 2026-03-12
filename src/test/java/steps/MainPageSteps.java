package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.MainPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageSteps extends BaseUI {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Given("user is logged in and on the main page")
    public void user_is_logged_in_and_on_the_main_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAndStay();
    }

    @When("user clicks on the {string} section")
    public void user_clicks_on_the_section(String section) {
        switch (section) {
            case "Accounts"               -> waitAndClick(mainPage.accountsSection);
            case "Customer Insights"      -> waitAndClick(mainPage.customerInsightsSection);
            case "Pay & transfer"         -> waitAndClick(mainPage.payAndTransferSection);
            case "Statements & documents" -> waitAndClick(mainPage.statementsAndDocumentsSection);
            case "Cards"                  -> waitAndClick(mainPage.cardsSection);
            case "Profile & Settings"     -> waitAndClick(mainPage.profileAndSettingsSection);
        }
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String section) {
        switch (section) {
            case "Accounts"               -> assertTrue(Driver.getDriver().getCurrentUrl().contains("https://my-wallet-wizard.lovable.app/"));
            case "Customer Insights"      -> assertTrue(Driver.getDriver().getCurrentUrl().contains("/insights"));
            case "Pay & transfer"         -> assertTrue(Driver.getDriver().getCurrentUrl().contains("/transfers"));
            case "Statements & documents" -> assertTrue(Driver.getDriver().getCurrentUrl().contains("/statements"));
            case "Cards"                  -> assertTrue(Driver.getDriver().getCurrentUrl().contains("/cards"));
            case "Profile & Settings"     -> assertTrue(Driver.getDriver().getCurrentUrl().contains("/account"));
        }
    }

}
