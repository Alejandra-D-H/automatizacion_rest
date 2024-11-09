
Feature: As a user, I want to retrieve all existing products.

  Scenario: Get all products
    Given I am connected as a user
    When I send a GET request to retrieve all the products
    Then all the products should be shown