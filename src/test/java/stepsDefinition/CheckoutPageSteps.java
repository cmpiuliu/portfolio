package stepsDefinition;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

public class CheckoutPageSteps {

    private CheckoutPage checkoutPage;
    private WebDriver driver;


    public CheckoutPageSteps() {
        this.driver = Hooks.driver;
        this.checkoutPage = new CheckoutPage(driver);
    }


    @Then("User inserts checkout information")
    private void userInsertsCheckoutInformation() {

    }
}
