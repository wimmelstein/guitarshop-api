Feature: Logging into the application
  Scenario: Logging in with a valid user
    Given I visit the login page
    When I enter the username "user"
    And I enter password "password"
    Then The title of the new page is "Create guitar"

  Scenario: Logging in with a wrong password
    Given I visit the login page
    When I enter the username "user"
    And I enter password "wrong_password"
    Then The url contains "?error"

  Scenario: Logging in with a disabled user
    Given I visit the login page
    When I enter the username "guest"
    And I enter password "nologin"
    Then The url contains "?error"