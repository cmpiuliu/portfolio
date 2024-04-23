Feature: Happy Path

  Background:
    Given The user is on the login page
    When User enters credentials "standard_user", "secret_sauce"
    And Clicks on the Login button

  Scenario: User can successfully place an order
    When User clicks on Add to Cart button for the desired product "Onesie"
    And Clicks on the Shopping Cart button
    And Clicks on the Checkout button
    Then User inserts checkout information
    And Clicks on the Continue button
    And Clicks on the Finish button
    Then The appropriate successful message 'message' is displayed


