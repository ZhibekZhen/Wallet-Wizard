package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import utils.BaseUI;
import utils.Driver;

public class LoginStep extends BaseUI {

    LoginPage loginPage = new LoginPage();

    @Given("user logs in with multiple valid credentials")
    public void successful_login() {
        loginPage.login();
    }

    @Given("user enters username {string} and password {string}")
    public void failed_login(String username, String password) {
        waitAndSendKeys(loginPage.loginInput, username);
        waitAndSendKeys(loginPage.passwordInput,password);
        waitAndClick(loginPage.signInButton);
    }
    @Then("verify user stays in login page")
    public void verify_user_stays_in_login_page() {
        Assertions.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }
}
