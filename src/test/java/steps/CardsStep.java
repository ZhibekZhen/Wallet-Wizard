package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CardsPage;
import utils.BaseUI;

public class CardsStep extends BaseUI{
    CardsPage cardsPage = new CardsPage();

    @When("user clicks on Cards section")
    public void user_clicks_on_cards_section() {
        waitAndClick(cardsPage.cardsLink);
    }
    @Then("verify user is navigated to Cards section")
    public void verify_user_is_navigated_to_Cards_section() {
        explicitWait(5).until(ExpectedConditions.visibilityOf(cardsPage.header));
        Assertions.assertEquals("Cards",cardsPage.header.getText());
    }
    @Then("verify user can open card detail modal")
    public void verify_user_can_open_card_detail_modal() {
        waitAndClick(cardsPage.activeCard);
        explicitWait(5).until(ExpectedConditions.visibilityOf(cardsPage.balanceInfo));
    }
    @Then("verify card details modal shows correct card information")
    public void verify_card_details_modal_shows_correct_card_information() {
        String actual = cardsPage.cardHolderName.getText();
        String expected = cardsPage.cardHolderNameInfo.getText();
        Assertions.assertEquals(expected,actual);
    }
    @Then("verify user can close the card details modal")
    public void verify_user_can_close_the_card_details_modal(){
        waitAndClick(cardsPage.closeBalanceInfoButton);
        explicitWait(5).until(ExpectedConditions.invisibilityOf(cardsPage.balanceInfo));
    }
    @Then("verify card number should display only last four digits")
    public void verify_card_number_should_display_only_last_four_digits() {
        Assertions.assertFalse(cardsPage.maskedCardNumber.getText().matches(".*\\d.*"));
        waitAndClick(cardsPage.eyeButton);
        Assertions.assertTrue(cardsPage.maskedCardNumber.getText().matches(".*\\d{4}$"));
    }
}

