import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPage;

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
    public void testStuff(){
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.login("standard_user","secret_sauce");
        loginPage.clickLoginButton();
        inventoryPage.addToCartDesiredProduct("Sauce Labs Onesie");
        inventoryPage.addToCartDesiredProduct("Sauce Labs Fleece Jacket");
        inventoryPage.retuString();
    }


}
