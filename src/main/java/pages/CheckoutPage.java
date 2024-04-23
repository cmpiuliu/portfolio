package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.xpath("//*[@class='btn_primary cart_button']");
    By cancelButton = By.xpath("//*[@class='cart_cancel_link btn_secondary']");


    public void inputFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void inputLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void inputPostalCode(String postalCode){
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }
    public void clickOnContinueBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
    }

    public void inputYourInformation (String firstName, String lastName, String postalCode){
        inputFirstName(firstName);
        inputLastName(lastName);
        inputPostalCode(postalCode);
    }

}
