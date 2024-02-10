package steps_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;


public class LoginPageSteps {

    WebDriver driver;
    private final LoginPage loginPage;

    public LoginPageSteps() {
        driver = BaseClass.getDriver();
        this.loginPage = new LoginPage(BaseClass.getDriver());
    }

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
            BaseClass.getDriver();
    }

    @When("User enters valid credentials {string}, {string}")
    public void user_enters_valid_credentials(String username, String passowrd) {
        loginPage.setUserNameField(username);
        loginPage.setPasswordField(passowrd);
    }

    @And("Clicks on the Login button")
    public void clicks_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User is successfully logged in to the landing page")
    public void user_is_succesfully_logged_in_to_the_landing_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }
}
