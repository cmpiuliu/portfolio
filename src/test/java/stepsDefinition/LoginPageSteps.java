package stepsDefinition;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginPageSteps {

    private LoginPage loginPage;
    private WebDriver driver;


    public LoginPageSteps() {
        this.driver = Hooks.driver;
        this.loginPage = new LoginPage(driver);
    }

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com/v1/");
        //assertTrue(driver.findElement(By.cssSelector("login_logo")).isDisplayed());

    }
    @When("User enters credentials {string}, {string}")
    public void userEntersValidCredentials(String username, String password) {
        loginPage.login(username,password);
    }

    @And("Clicks on the Login button")
    public void clicksOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User is successfully logged in to the landing page")
    public void userIsSuccessfullyLoggedInToTheLandingPage() {
         assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/v1/inventory.html");
    }

    @Then("The appropriate error message {string} is displayed")
    public void theAppropriateErrorMessageIsDisplayed(String expected) {
        assertEquals(expected,loginPage.getErrorMessage());
        System.out.println(loginPage.getErrorMessage());
    }
}




