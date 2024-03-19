
Feature: Login Page

  Scenario: Successful login with valid credentials
    Given The user is on the login page
    When User enters valid credentials "standard_user", "secret_sauce"
    And Clicks on the Login button
    Then User is successfully logged in to the landing page


    #  basePage.navigateTo("https://www.saucedemo.com/v1/");