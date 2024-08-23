package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Before;
import io.cucumber.java.After;


public class Hooks {

    public static WebDriver driver;

    @Before
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Add any desired Chrome options
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);

    }

    /*@After
    public static void tearDown() {
        //if (driver != null) {

          //  driver.quit();
            driver.close();
        System.out.println("AFTER");

        }*/
    }