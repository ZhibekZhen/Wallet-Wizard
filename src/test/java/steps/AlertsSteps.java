package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.AlertsPage;
import pages.LoginPage;
import pages.MainPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class AlertsSteps extends BaseUI {

    LoginPage loginPage = new LoginPage();
    AlertsPage alertsPage =new AlertsPage();
    MainPage mainPage = new MainPage();

    @Given("user is logged in and navigated to Profile & Settings Alerts section")
    public void user_is_logged_in_and_navigated_to_profile_settings_alerts_section() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAndStay();
        waitAndClick(mainPage.profileAndSettingsSection);
        waitAndClick(alertsPage.alertsSection);
    }

    @Given("the {string} radio button is unselected")
    public void the_radio_button_is_unselected(String alert) {
        WebElement button = alertsPage.alertsButtons.get(alert);
        if (button.isSelected() || button.getAttribute("aria-checked").equals("true")) {
            button.click();
        }
    }

    @When("user clicks on the {string} radio button")
    public void user_clicks_on_the_radio_button(String alert) {
        waitAndClick(alertsPage.alertsButtons.get(alert));
    }

    @Then("the {string} radio button should be selected")
    public void the_radio_button_should_be_selected(String alert) {
        WebElement button = alertsPage.alertsButtons.get(alert);

        Assertions.assertTrue(button.getAttribute("aria-checked").equals("true"));
    }

}
