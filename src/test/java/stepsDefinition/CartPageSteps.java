package stepsDefinition;

import hooks.Hooks;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class CartPageSteps {
    private WebDriver driver;
    private CartPage cartPage;

    public CartPageSteps() {
        this.driver = Hooks.driver;
        this.cartPage = new CartPage(driver);
    }


    @And("Clicks on the Checkout button")
    public void clicksOnTheCheckoutButton() {
        cartPage.clickOnCheckoutBtn();
    }
}

