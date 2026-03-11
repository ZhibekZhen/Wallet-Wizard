package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.StatementsDocumentsPage;
import utils.BaseUI;
import utils.Driver;

import java.time.Duration;

public class StatementsDocumentsSteps extends BaseUI {

    WebDriver driver = Driver.getDriver();
    LoginStep loginStep = new LoginStep();
    StatementsDocumentsPage page = new StatementsDocumentsPage();





    @When("user clicks the Statements tab")
    public void user_clicks_the_statements_tab() {
       waitAndClick(page.statementsTab);

    }

    @Then("verify user is on the Statements and Documents page")
    public void verify_user_is_on_the_statements_and_documents_page() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("statements"));
    }


    @And("verify statements are displayed")
    public void verify_statements_are_displayed() {
        Assertions.assertTrue(page.downloadBtn.size() > 0);
        for(WebElement statement : page.downloadBtn){
            Assertions.assertTrue(statement.isDisplayed());
        }


    }
    @And("verify documents are downloadable")
    public void verify_documents_are_downloadable() {
        for(WebElement button : page.downloadBtn){
           Assertions.assertTrue(button.isDisplayed());

        }
    }


}
