package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class StatementsDocumentsPage {
    public StatementsDocumentsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

   @FindBy(xpath = "//h2[contains(text(),'Good')]")
   public WebElement accountPageHeader;


    @FindBy(xpath = "//a[text()='Statements & documents']")
    public WebElement statementsTab;

    @FindBy(xpath = "//button[text()='PDF']")
    public List<WebElement> downloadBtn;

}
