import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TestClass {
    private final WebDriver driver;
    private InventoryPage inventoryPage;
    private LoginPage loginPage;

    public TestClass(){
        this.driver = new ChromeDriver();
        this.inventoryPage = new InventoryPage(driver);
        this.loginPage = new LoginPage(driver);
    }



    @Test
    public void testStuff() {
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickLoginButton();
        inventoryPage.sortBy("Z to A");

    }
}
