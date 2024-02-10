Feature: Login Page

  Scenario: Succesfull login with valid credentials
    Given The user is on the login page
    When User enters valid credentials "username", "password"
    And Clicks on the Login button
    Then User is successfully logged in to the landing page