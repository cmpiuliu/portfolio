package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By userNameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//*[@id='login_button_container']/div/form/h3");


    public void setUserNameField(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(username);
    }

    public void setPasswordField(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }


    public void login(String username, String password) {
        setUserNameField(username);
        setPasswordField(password);
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(errorMessage));
        return driver.findElement(errorMessage).getText();
    }

}
