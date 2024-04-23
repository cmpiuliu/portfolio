package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    By checkoutButton = By.xpath("//*[@class='btn_action checkout_button']");
    By continueShoppingBtn = By.xpath("//*[@class='btn_secondary']");
    By removeButton = By.xpath("//button[contains(text(),'REMOVE')]");


    public void clickOnCheckoutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        driver.findElement(checkoutButton).click();
    }



}
