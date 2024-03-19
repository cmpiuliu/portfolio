package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By burgerMenuButton = By.id("menu_button_container");
    By shoppingCartContainer = By.id("shopping_cart_container");
    By shoppingCartBadgeCounter = By.xpath("//div[@class='shopping_cart_container']//span");
    By addToCartButton = By.xpath("//button[text()='ADD TO CART']");

    public String getShoppingCartBadgeCounter() {
        return driver.findElement(shoppingCartBadgeCounter).getText();

    }

    public void retuString() {
        System.out.println(getShoppingCartBadgeCounter());
    }


    public void addToCartDesiredProduct(String criteria) {
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        boolean found = false;

        for (WebElement product : products) {
            String productName = product.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
            if (productName.equals(criteria)) {
                found = true;
                WebElement addtoCart = product.findElement(By.xpath(".//button[contains(text(),'ADD TO CART')]"));
                addtoCart.click();
                break;
            }

            }
        if (!found) {
            System.out.println("Desired product not found.");
        }
    }
}


