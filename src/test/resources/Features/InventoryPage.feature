Feature: Inventory Page

  Background:
    Given The user is on the login page
    When User enters credentials "standard_user", "secret_sauce"
    And Clicks on the Login button

  Scenario Outline: Sorting products alphabetically ascending and descending
    And User sorts products by desired criteria "<sortByName>"
    Then Verify if the alphabetically "<sortByName>" sorting is accurate
    Examples:
      | sortByName  |
      | Z to A |
      | Z to A |

  Scenario Outline: Sorting products by price
    And User sorts products by desired criteria "<priceType>"
    Then Verify if the products are sorted by price "<priceType>"
    Examples:
      | priceType   |
      | high to low |
      | low to high |

  Scenario: Adding items to the Cart from the product listing page
      When User clicks on Add to Cart button for the desired product "Onesie"
      Then Verify if the cart items counting badge updates correctly

  Scenario: Removing Cart items from the product listing page
      When User clicks on Add to Cart button for the desired product "Onesie"
      And User clicks on Remove button for the desired product "Onesie"
      Then Verify if the cart items counting badge updates correctly
