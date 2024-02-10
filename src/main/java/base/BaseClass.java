package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass {
    private static WebDriver driver;


    @BeforeMethod
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/v1/");
        }
        System.out.println("pe aici trece");

        return driver;
    }


    @AfterMethod
    public static void quitDriver() {
        System.out.println("macar in metoda intra?");
            driver.close();
        System.out.println("a atins close quit method...");
        }
    }




/*
driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/v1/");*/
