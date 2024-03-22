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
      | A to Z |
      | Z to A |

  Scenario Outline: Sorting products by price
    And User sorts products by desired criteria "<priceType>"
    Then Verify if the products are sorted by price "<priceType>"
    Examples:
      | priceType   |
      | high to low |
      | low to high |

