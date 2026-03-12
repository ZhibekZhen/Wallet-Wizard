package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.BusinessDetailsPage;
import utils.BaseUI;

public class BusinessDetailsSteps extends BaseUI {

    private final BusinessDetailsPage businessDetailsPage = new BusinessDetailsPage();

    @When("user clicks Business details in the sidebar")
    public void userClicksBusinessDetailsInTheSidebar() {
        waitAndClick(businessDetailsPage.pageHeading);
        waitAndClick(businessDetailsPage.businessDetailsHeading);
        businessDetailsPage.verifyBusinessDetailsFormIsVisible();
    }

    @Then("Business Details form should be visible")
    public void businessDetailsFormShouldBeVisible() {
        businessDetailsPage.verifyBusinessDetailsFormIsVisible();
    }

    @And("Business Name input should be visible")
    public void businessNameInputShouldBeVisible() {
        waitUntilVisible(20, businessDetailsPage.businessNameInput);
        Assertions.assertTrue(
                businessDetailsPage.businessNameInput.isDisplayed(),
                "Business Name input field should be visible"
        );
    }

    @And("Annual Revenue input should be visible")
    public void annualRevenueInputShouldBeVisible() {
        waitUntilVisible(20, businessDetailsPage.annualRevenueInput);
        Assertions.assertTrue(
                businessDetailsPage.annualRevenueInput.isDisplayed(),
                "Annual Revenue input field should be visible"
        );
    }

    @And("Industry input should be visible")
    public void industryInputShouldBeVisible() {
        waitUntilVisible(20, businessDetailsPage.industryInput);
        Assertions.assertTrue(
                businessDetailsPage.industryInput.isDisplayed(),
                "Industry input field should be visible"
        );
    }

    @Then("Save Changes button should be visible")
    public void saveChangesButtonShouldBeVisible() {
        waitUntilVisible(20, businessDetailsPage.saveChangesButton);
        Assertions.assertTrue(
                businessDetailsPage.saveChangesButton.isDisplayed(),
                "Save Changes button should be visible on Business details page"
        );
    }

    @And("Save Changes button should be enabled")
    public void saveChangesButtonShouldBeEnabled() {
        Assertions.assertTrue(
                businessDetailsPage.saveChangesButton.isEnabled(),
                "Save Changes button should be enabled on Business details page"
        );
    }

    @And("user enters business name {string}")
    public void userEntersBusinessName(String businessName) {
        businessDetailsPage.enterBusinessName(businessName);
    }

    @And("user enters annual revenue {string}")
    public void userEntersAnnualRevenue(String revenue) {
        businessDetailsPage.enterAnnualRevenue(revenue);
    }

    @And("user enters industry {string}")
    public void userEntersIndustry(String industry) {
        businessDetailsPage.enterIndustry(industry);
    }

    @And("user clicks the Save Changes button on business details")
    public void userClicksSaveChangesButtonOnBusinessDetails() {
        businessDetailsPage.clickSaveChanges();
    }

    @Then("business name field should contain {string}")
    public void businessNameFieldShouldContain(String expectedValue) {
        businessDetailsPage.verifyBusinessNameFieldContains(expectedValue);
    }
}
