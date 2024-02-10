import base.BaseClass;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginTest(){
        driver = BaseClass.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginStandard_user(){
        loginPage.login("standard_user","secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/v1/inventory.html");
        System.out.printf(driver.getCurrentUrl());
    }
}
