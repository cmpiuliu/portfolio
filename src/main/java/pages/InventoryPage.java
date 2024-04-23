package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
    By sortDropDownButton = By.cssSelector(".product_sort_container");

    public String getShoppingCartBadgeCounter() {
        try {
            WebElement cartBadgeCounter = driver.findElement(shoppingCartBadgeCounter);
            return cartBadgeCounter.getText();
        } catch (NoSuchElementException e){
            System.out.println("The shopping cart is currently empty");
            return "0";
        }
    }

    public void retuString() {
        System.out.println(getShoppingCartBadgeCounter());
    }


    public void addToCartDesiredProduct(String criteria) {
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        boolean found = false;

        for (WebElement product : products) {
            String productName = product.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
            if (productName.contains(criteria)) {
                found = true;
                WebElement addtoCart = product.findElement(By.xpath(".//button[contains(text(),'ADD TO CART')]"));
                addtoCart.click();
                break;
            }
        }
        if (!found) {
            System.out.println(criteria + " desired product not found.");
        }
    }

    public void sortBy(String criteria) {
        //to work case sensitive matters
        wait.until(ExpectedConditions.elementToBeClickable(sortDropDownButton));
        driver.findElement(sortDropDownButton).click();

        List<WebElement> sortingOptions = driver.findElements(By.cssSelector(".product_sort_container option"));
        for (WebElement option : sortingOptions) {
            if (option.getText().contains(criteria)) {
                wait.until(ExpectedConditions.elementToBeClickable(option));
                option.click();
                break;
            }
        }
    }

    public String test () {
        List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> sortedNames = new ArrayList<>();
        for (WebElement element : productElements){
            sortedNames.add(element.getText());
        }
        /*List<String> expectedSortedNames = new ArrayList<>(sortedNames);
        Collections.sort(expectedSortedNames);*/
        return String.valueOf(sortedNames);
    }

    public void clickOnShoppingCartContainer(){
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartContainer));
        driver.findElement(shoppingCartContainer).click();
    }


}


