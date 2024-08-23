package stepsDefinition;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

public class CheckoutPageSteps {

    private WebDriver driver;
    private CheckoutPage checkoutPage;

    public CheckoutPageSteps(){
        this.driver = Hooks.driver;
        this.checkoutPage = new CheckoutPage(driver);
    }
    @Then("User inserts checkout information")
    public void userInsertsCheckoutInformation() {
        checkoutPage.inputYourInformation("Fist Name", "Last Name","123456");
    }
    @And("Clicks on the Continue button")
    public void clicksOnTheContinueButton() {
        checkoutPage.clickOnContinueBtn();
    }
}
