package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AccountsPage;
import utils.BaseUI;
import utils.Driver;

public class AccountsStep extends BaseUI {
    AccountsPage accountsPage = new AccountsPage();

    @When("user clicks on Accounts section")
    public void user_clicks_on_accounts_section() {
        waitAndClick(accountsPage.accountsLink);
    }

    @Then("verify user is navigated to Accounts section")
    public void verify_user_is_navigated_to_accounts_section() {
        explicitWait(10).until(ExpectedConditions.visibilityOf(accountsPage.header));
        Assertions.assertEquals("Good afternoon",accountsPage.header.getText());
    }

    @Then("verify user can click Credit option and open Credit account")
    public void verify_user_can_click_credit_option_and_open_credit_account() {
        waitAndClick(accountsPage.allAccountsDropdown);
        waitAndClick(accountsPage.creditOption);
        Assertions.assertTrue(accountsPage.creditAccount.getText().contains("REWARDS CREDIT"));
    }

    @Then("verify user can get statements&documents of chosen account")
    public void verify_user_can_get_statements_documents_of_chosen_account() {
        waitAndClick(accountsPage.creditAccount);
        explicitWait(10).until(ExpectedConditions.visibilityOf(accountsPage.viewStatements));
        waitAndClick(accountsPage.viewStatements);
        Assertions.assertTrue(Driver.getDriver().getCurrentUrl().contains("statements"));
    }

    @When("user returns back can Transfer money")
    public void user_returns_back_can_transfer_money() {
       Driver.getDriver().navigate().back();
       waitAndClick(accountsPage.transferMoneyButton);
        Assertions.assertTrue(Driver.getDriver().getCurrentUrl().contains("transfers"));
    }

//    @Then("user clicks on Accounts section and can set Savings goal")
//    public void user_clicks_on_accounts_section_and_can_set_savings_goal() {
//        Actions actions = new Actions(Driver.getDriver());
//        actions.moveToElement(accountsPage.accountsLink).click().perform();
//        waitAndClick(accountsPage.moreSavingsDropdown);
//        waitAndClick(accountsPage.setSavingsGoalOption);
//
//    }
}
