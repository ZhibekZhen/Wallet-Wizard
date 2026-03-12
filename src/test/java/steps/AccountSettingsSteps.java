package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.AccountSettingsPage;

    public class AccountSettingsSteps {

        AccountSettingsPage accountSettingsPage = new AccountSettingsPage();

        @When("user clicks Account settings")
        public void user_clicks_account_settings() {
            accountSettingsPage.accountSettings.click();
        }

        @When("user enables Go Paperless")
        public void user_enables_go_paperless() {
            accountSettingsPage.goPaperlessToggle.click();
        }

        @Then("Go Paperless should be enabled")
        public void go_paperless_should_be_enabled() {
            Assertions.assertTrue(accountSettingsPage.goPaperlessToggle.isSelected());
        }

        @Then("account nickname should be {string}")
        public void account_nickname_should_be(String nickname) {
            Assertions.assertEquals(nickname,
                    accountSettingsPage.accountNickname.getAttribute("value"));
        }

        @When("user enables Hide Account")
        public void user_enables_hide_account() {
            accountSettingsPage.hideAccountToggle.click();
        }

        @Then("account should be hidden")
        public void account_should_be_hidden() {
            Assertions.assertTrue(accountSettingsPage.hideAccountToggle.isSelected());
        }

    }

