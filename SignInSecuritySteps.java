package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import pages.SignInSecurityPage;
import utils.ConfigurationReader;
import utils.Driver;

public class SignInSecuritySteps {
    LoginPage loginPage = new LoginPage();
    SignInSecurityPage securityPage = new SignInSecurityPage();

    @Given("user logs in to VaultBank")
    public void user_logs_in_to_vaultbank() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        loginPage.email.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton.click();
    }

    @When("user clicks {string}")
    public void user_clicks_profile_settings(String menu) {
        if(menu.equals("Profile & settings")){
            securityPage.profileSettings.click();
        }
        else if(menu.equals("Sign-in & security")){
            securityPage.signInSecurity.click();
        }
        else if(menu.equals("Change Password")) {
            securityPage.changePassword.click();
        }
    }
    @When("user enables Two-Factor Authentication")
    public void user_enables_two_factor_authentication() {
        securityPage.twoFactorToggle.click();
    }

    @Then("Two-Factor Authentication should be enabled")
    public void two_factor_authentication_should_be_enabled() {
        Assertions.assertTrue(securityPage.twoFactorToggle.isSelected());
    }
}

