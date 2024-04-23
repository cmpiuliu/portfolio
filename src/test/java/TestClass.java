import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class TestClass {
    private final WebDriver driver;
    private InventoryPage inventoryPage;
    private LoginPage loginPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OverviewPage overviewPage;

    public TestClass(){
        this.driver = new ChromeDriver();
        this.inventoryPage = new InventoryPage(driver);
        this.loginPage = new LoginPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.overviewPage = new OverviewPage(driver);
    }

//THANK YOU FOR YOUR ORDER

    @Test
    public void testStuff() {
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickLoginButton();
        inventoryPage.addToCartDesiredProduct("Sauce Labs Bolt T-Shirt");
        inventoryPage.addToCartDesiredProduct("Sauce Labs Fleece Jacket");
        assertNotNull(inventoryPage.getShoppingCartBadgeCounter());
        System.out.println(inventoryPage.getShoppingCartBadgeCounter());
        inventoryPage.clickOnShoppingCartContainer();
        cartPage.clickOnCheckoutBtn();
        checkoutPage.inputYourInformation("First Placeholder","Last Placeholder","123456");
        checkoutPage.clickOnContinueBtn();
        overviewPage.clickOnFinishButton();
        assertEquals("THANK YOU FOR YOUR ORDER",overviewPage.getCompleteHeader());
        System.out.println(overviewPage.getCompleteHeader());
    }

}
