Feature: Endpoint tests

  Scenario: Retrieve all guitars is status OK
    When I retrieve all guitars
    Then I get http status 200

  Scenario: Getting a list of all guitars
    When I retrieve all guitars
    Then I get a list of 3 guitars

  Scenario: Getting one guitar
    When I retrieve guitar with id 1000001
    Then The guitar brand is "Fender"
