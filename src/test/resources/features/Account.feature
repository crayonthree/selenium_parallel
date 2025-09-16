Feature: User Account Management

  Scenario: User should be able to login with valid credentials
    Given User is on the login page
    When User enters email "ayerramilli@yahoo.com" and password "TestPassword@123"
    And User clicks the login button
    Then User should be redirected to setup 2-Step Verification after successful login

  Scenario: User should not be able to login with invalid credentials
    Given User is on the login page
    When User enters email "<email>" and password "<password>"
    And User clicks the login button
    Then User should see an error message

    Examples:
      | email                | password          |
      | user@test.com        | TestPassword@123@4443  |
      | invalid@yahoo.com  | wrongpassword@123     |
      | user@example.com      | incorrectpassword@345  |