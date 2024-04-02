package stepsDefinition;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.InventoryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class InventoryPageSteps {

    private InventoryPage inventoryPage;
    private WebDriver driver;

    public InventoryPageSteps() {
        this.driver = Hooks.driver;
        this.inventoryPage = new InventoryPage(driver);
    }

    @When("User sorts products by desired criteria {string}")
    public void user_sorts_by_desired_criteria(String criteria) {
        inventoryPage.sortBy(criteria);
    }

    @Then("Verify if the alphabetically {string} sorting is accurate")
    public void verifyIfTheAlphabeticallyDescendingSortingIsAccurate(String criteria) {
        List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> sortedNames = new ArrayList<>();
        for (WebElement element : productElements) {
            sortedNames.add(element.getText());
        }
        List<String> expectedSortedNames = new ArrayList<>(sortedNames);
        switch (criteria) {
            case "Name A to Z":
                Collections.sort(expectedSortedNames);
                assertEquals(expectedSortedNames, sortedNames);
                System.out.println("Actual Names A to Z are: " + sortedNames);
                System.out.println("Expected Names A to Z are: " + expectedSortedNames);
                break;

            case "Name Z to A":
                expectedSortedNames.sort(Collections.reverseOrder());
                assertEquals(expectedSortedNames, sortedNames);
                System.out.println("Actual Names Z to A are: " + sortedNames);
                System.out.println("Expected Names Z to A are: " + expectedSortedNames);
                break;
        }
    }

    @Then("Verify if the products are sorted by price {string}")
    public void verifyIfTheProductsAreSortedByPriceLowToHigh(String criteria) {
        List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> sortedPrices = new ArrayList<>();
        for (WebElement element : productElements) {
            sortedPrices.add(Double.parseDouble(element.getText().replace("$", "")));
        }
        List<Double> expectedSortedPrices = new ArrayList<>(sortedPrices);
        switch (criteria) {
            case "low to high":
                Collections.sort(expectedSortedPrices);
                assertEquals(expectedSortedPrices, sortedPrices);
                System.out.println("Actual prices are: " + sortedPrices);
                System.out.println("Expected prices are: " + expectedSortedPrices);
                break;

            case "high to low":
                expectedSortedPrices.sort(Collections.reverseOrder());
                assertEquals(expectedSortedPrices, sortedPrices);
                System.out.println("Actual prices are: " + sortedPrices);
                System.out.println("Expected prices are: " + expectedSortedPrices);
                break;
        }
    }
}
