package stepsDefinition;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.OverviewPage;

import static org.junit.Assert.assertEquals;

public class OverviewPageSteps {

    private WebDriver driver;
    private OverviewPage overviewPage;
    public OverviewPageSteps(){
        this.driver = Hooks.driver;
        this.overviewPage = new OverviewPage(driver);
    }

    @And("Clicks on the Finish button")
    public void clicksOnTheFinishButton() {
        overviewPage.clickOnFinishButton();
    }

    @Then("The appropriate successful message {string} is displayed")
    public void theAppropriateSuccessfulMessageMessageIsDisplayed(String expected) {
        assertEquals(expected,overviewPage.getCompleteHeader());
    }
}
