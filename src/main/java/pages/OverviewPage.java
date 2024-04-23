package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OverviewPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public OverviewPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By finishButton = By.xpath("//*[@class='btn_action cart_button']");
    By cancelButton = By.xpath("//*[@class='cart_cancel_link btn_secondary']");
    By completeHeader = By.xpath("//*[@class='complete-header']");


    public void clickOnFinishButton(){
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        driver.findElement(finishButton).click();
    }

    public String getCompleteHeader(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader));
        return driver.findElement(completeHeader).getText();
    }











}
