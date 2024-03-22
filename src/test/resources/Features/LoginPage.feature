Feature: Login Page

  Background:
    Given The user is on the login page

  Scenario: Verify Successful Login
    When User enters credentials "standard_user", "secret_sauce"
    And Clicks on the Login button
    Then User is successfully logged in to the landing page

  Scenario: Verify unsuccessful Login with Invalid Credentials
    When User enters credentials "invalid_user", "invalid_password"
    And Clicks on the Login button
    Then The appropriate error message "Epic sadface: Username and password do not match any user in this service" is displayed

  Scenario Outline: Verify mandatory fields
    When User enters credentials "<username>", "<password>"
    And Clicks on the Login button
    Then The appropriate error message "<errorMessage>" is displayed
    Examples:
      | username      | password     | errorMessage                       |
      |               |              | Epic sadface: Username is required |
      | standard_user |              | Epic sadface: Password is required |
      |               | secret_sauce | Epic sadface: Username is required |


  Scenario Outline: Verify case sensitivity
    When User enters credentials "<username>", "<password>"
    And Clicks on the Login button
    Then The appropriate error message "<errorMessage>" is displayed
    Examples:
      | username      | password     | errorMessage                                                              |
      | STANDARD_USER | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | standard_user | SECRET_SAUCE | Epic sadface: Username and password do not match any user in this service |
    